let filter_domain = document.getElementById('filter-domain');
let filter_specialisation = document.getElementById('filter-specialisation');
let table_data_current = null;
window.onload = fetch_placement_student;

filter_domain.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (filter_domain.checkValidity() === true) {
        console.log(document.getElementById('domain_name').value);
        let response = await fetch('api/placement/domain', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                domain: document.getElementById('domain_name').value,
            })
        });
        if(response['status'] === 200){
            document.getElementById('login-alert_a').style.display = "none";
            document.getElementById('whole_table').style.display = "block";
            let data = await response.json();
            console.log(data);
            load_table(data);
        }
        else{
            document.getElementById('login-alert_a').style.display = "block";
            document.getElementById('whole_table').style.display = "none";
        }

    } else {
        filter_domain.classList.add('was-validated');
    }
});

filter_specialisation.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (filter_specialisation.checkValidity() === true) {
        let response = await fetch('api/placement/specialisation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                specialisation: document.getElementById('specialisaton_name').value,
            })
        });
        if(response['status'] === 200){
            document.getElementById('login-alert_b').style.display = "none";
            document.getElementById('whole_table').style.display = "block";
            let data = await response.json();
            console.log(data);
            load_table(data);
        }
        else{
            document.getElementById('login-alert_b').style.display = "block";
            document.getElementById('whole_table').style.display = "none";
        }

    } else {
        filter_domain.classList.add('was-validated');
    }
});

function load_table(data){
    let table_data = document.getElementById("table_data");
    table_data.innerHTML = '';
    for(let i = 0;i<data.length;i++) {
        let tr_data = document.createElement('tr');
        tr_data.innerHTML = '<th scope="row">' + (i + 1) + '</th>\n' +
            '<td>' + data[i]['student']['student_id'] + '</td>\n' +
            '<td>' + data[i]['student']['first_name'] + '</td>\n' +
            '<td>' + data[i]['student']['last_name'] + '</td>\n' +
            '<td>' + data[i]['student']['domain'] + '</td>\n' +
            '<td>' + data[i]['student']['specialisation'] + '</td>\n' +
            '<td>' + data[i]['student']['cgpa'] + '</td>' +
            '<td>' + data[i]['placement']['organisation'] + '</td>' +
            '<td>' + data[i]['placement']['minimum_grade'] + '</td>' +
            '<td>' + data[i]['placement']['description'] + '</td>' +
            '<td>' + data[i]['placement']['profile'] + '</td>' +
            '<td>' + data[i]['about'] + '</td>' +
            '<td>' + data[i]['cv'] + '</td>' +
            '<td>' + '<input type="checkbox" value="i" name="radio_button">' + '</td>\n';
        table_data.appendChild(tr_data);
    }
    console.log("LOADING TABLE....");
    table_data_current = data;
}

async function fetch_placement_student() {
    let response = await fetch("api/placement/get");
    let data = await response.json(); // read response body and parse as JSON
    console.log(data);
    load_table(data);
}

async function submit_button(){
    let button_value = document.getElementsByName("radio_button");
    let student_ids = [];
    let placement_ids = [];
    let buttons = [];
    for(i=0; i<button_value.length; i++){
        if(button_value[i].checked) {
            student_ids.push(table_data_current[i]['student']['student_id']);
            placement_ids.push(table_data_current[i]['placement']['id']);
            buttons.push(i);
        }
    }
    let response = await fetch("api/placement/select", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            student_ids : student_ids,
            placement_ids : placement_ids,
        })
    });
    if(response['status'] === 200) {
        document.getElementById("update_alert").style.display = "block";
        location.reload();
        fetch_placement_student();
    }
}

async function sort_button(){
    let response = await fetch("api/placement/sort");
    let data = await response.json();
    console.log(data);
    load_table(data);
}