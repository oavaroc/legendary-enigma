let baseUrl = '/TRMS';
let nav = document.getElementById('navBar');
let loggedUser = null;
checkLogin();
setNav();
function setNav() {
    nav.innerHTML = `
            <a href="index.html"><strong>Home</strong></a>`;
    if (!loggedUser) {
        nav.innerHTML += `
            <form>
                <label for="user">Username: </label>
                <input id="user" name="user" type="text" />
                <label for="pass"> Password: </label>
                <input id="pass" name="pass" type="password" />
                <button class="button button1" type="button" id="loginBtn">Log In</button>
            </form>
        `;
    } else {
        nav.innerHTML += `
            <span>
            <button class="button button2" type ="button" id="createReimb">File Reimbursement</button>&nbsp;

            <button class="button button3" type ="button" id="viewMyReimb">View My Reimbursements</button>&nbsp;

            <button class="button button4" type ="button" id="viewMessages">Messages</button>&nbsp;
                <a href="profile.html">${loggedUser.username}&nbsp;</a>
                <button type="button" id="loginBtn">Log Out</button>
            </span>
        `;
    }
            let createReimb = document.getElementById('createReimb');
            if (loggedUser) createReimb.onclick = createReimburse;
            let viewMyReimb = document.getElementById('viewMyReimb');
            if (loggedUser) viewMyReimb.onclick = fetchReimbursements;
            let viewMessages = document.getElementById('viewMessages');
            if (loggedUser) viewMessages.onclick = fetchMessages;

    let loginBtn = document.getElementById('loginBtn');
    if (loggedUser) loginBtn.onclick = logout;
    else loginBtn.onclick = login;
}
//POST http://localhost:8080/TRMS/user/login?user=user&pass=pass
async function login() {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/user/login?';
    url += 'user=' + document.getElementById('user').value + '&';
    url += 'pass=' + document.getElementById('pass').value;
    let response = await fetch(url, {method: 'POST'});
    
    switch (response.status) {
        case 200: // successful
            loggedUser = await response.json();
            setNav();
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            document.getElementById('pass').value = '';
            break;
        case 404: // user not found
            alert('TESTING That user does not exist.');
            document.getElementById('user').value = '';
            document.getElementById('pass').value = '';
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
//GET http://localhost:8080/TRMS/reimburse
let allReimbursements=null;
async function fetchReimbursements() {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/reimburse';
    let response = await fetch(url, {method: 'GET'});
    
    switch (response.status) {
        case 200: // successful
            allReimbursements = await response.json();
            setNav();
            populateReimbursements();
            break;
        case 400: // incorrect password
            alert('REPLACE WITH 400 MESSAGE');
            break;
        case 404: // user not found
            alert('REPLACE WITH 404 MESSAGE');
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
async function logout() {
    let url = baseUrl + '/user/login';
    let response = await fetch(url, {method:'DELETE'});

    if (response.status != 200){} //alert('Something went wrong.');
    loggedUser = null;
    let reimbursementSection = document.getElementById('reimbursementSection');
    reimbursementSection.innerHTML = ``;
    setNav();
}

async function checkLogin() {
    let url = baseUrl + '/user';
    let response = await fetch(url);
    if (response.status === 200) loggedUser = await response.json();
    setNav();
}