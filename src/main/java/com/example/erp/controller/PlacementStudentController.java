package com.example.erp.controller;

import com.example.erp.bean.Employee;
import com.example.erp.bean.Placement;
import com.example.erp.bean.Placement_Student;
import com.example.erp.bean.Student;
import com.example.erp.dao.PlacementStudentDao;
import com.example.erp.dao.implementation.PlacementStudentDaoImpl;
import com.example.erp.service.EmployeeService;
import com.example.erp.service.PlacementService;
import com.example.erp.service.PlacementStudentService;
import com.example.erp.service.StudentService;
import org.glassfish.jersey.internal.util.collection.StringIgnoreCaseKeyComparator;
import com.example.erp.bean.PlacementSelection;

import javax.print.attribute.URISyntax;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import com.example.erp.bean.Random;
import org.glassfish.jersey.media.multipart.FormDataParam;

class SortByGrade implements Comparator<Random>{
    public int compare(Random a, Random b){
        if(Float.parseFloat(a.getStudent().getCgpa()) > Float.parseFloat(b.getStudent().getCgpa())) return 1;
        else if(Float.parseFloat(a.getStudent().getCgpa()) > Float.parseFloat(b.getStudent().getCgpa())) return 0;
        else return -1;
    }
}

@Path("placement")
public class PlacementStudentController {
    PlacementStudentService placementStudentService = new PlacementStudentService();
    PlacementService placementService = new PlacementService();
    StudentService studentService = new StudentService();
    PlacementStudentDao placementStudentDao = new PlacementStudentDaoImpl();
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchStudents(){
        List<Random> randoms= new ArrayList<>();
        List<Placement_Student> placementStudents = placementStudentService.getPlacementStudents(); //all placement student with acceptance = pending
        for(Placement_Student p : placementStudents){
            Placement placement = placementService.getPlacement(p.getPlacement_id());
            Student student = studentService.getStudentId(p.getStudent_id());
            String about = p.getAbout();
            String cv = p.getCv_application();
            randoms.add(new Random(about, cv, student, placement));
        }

        return Response.ok().entity(randoms).build();
    }

    @POST
    @Path("/domain")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response filterDomain(Student domain) throws URISyntaxException {
        List<Random> randoms= new ArrayList<>();
        List<Placement_Student> placementStudents = placementStudentService.filterByDomain(domain);
        for(Placement_Student p : placementStudents){
            Placement placement = placementService.getPlacement(p.getPlacement_id());
            Student student = studentService.getStudentId(p.getStudent_id());
            String about = p.getAbout();
            String cv = p.getCv_application();
            randoms.add(new Random(about, cv, student, placement));
        }
        if(randoms.isEmpty()){
            return Response.noContent().build();
        }
        return Response.ok().entity(randoms).build();
    }

    @POST
    @Path("/specialisation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response filterSpecialisation(Student specialisation) throws URISyntaxException {
        List<Random> randoms= new ArrayList<>();
        List<Placement_Student> placementStudents = placementStudentService.filterBySpecialisation(specialisation);
        for(Placement_Student p : placementStudents){
            Placement placement = placementService.getPlacement(p.getPlacement_id());
            Student student = studentService.getStudentId(p.getStudent_id());
            String about = p.getAbout();
            String cv = p.getCv_application();
            randoms.add(new Random(about, cv, student, placement));
        }
        if(randoms.isEmpty()){
            return Response.noContent().build();
        }
        return Response.ok().entity(randoms).build();
    }

    @POST
    @Path("/select")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response selectPlacement(PlacementSelection request) throws URISyntaxException {
        System.out.println(request);
        int updatedEntries = placementStudentDao.updatePlacementStatus(request);
        if(updatedEntries == 0)
            return Response.noContent().build();
        return Response.ok().build();
    }

    @GET
    @Path("/sort")
    public Response sortByGrade() throws URISyntaxException {
        List<Random> randoms= new ArrayList<>();
        List<Placement_Student> placementStudents = placementStudentService.getPlacementStudents();
        for(Placement_Student p : placementStudents){
            Placement placement = placementService.getPlacement(p.getPlacement_id());
            Student student = studentService.getStudentId(p.getStudent_id());
            String about = p.getAbout();
            String cv = p.getCv_application();
            randoms.add(new Random(about, cv, student, placement));
        }
        for(Random r : randoms) System.out.print(r.getStudent().getCgpa() + " ");
        System.out.println();
        Collections.sort(randoms, new SortByGrade());
        for(Random r : randoms) System.out.print(r.getStudent().getCgpa() + " ");
        return Response.ok().entity(randoms).build();
    }
}
