checkLogin();//.then(fetchReimbursements).then(populateReimbursements);

let messageUser = null;
function populateReimbursements() {
    if (loggedUser) {
        let reimbursements = allReimbursements;
        //console.log(reimbursements);
        let reimbursementSection = document.getElementById('reimbursementSection');
        reimbursementSection.innerHTML = ``;
        if (loggedUser.department.id === 8)
            populateEmpReim(reimbursements, reimbursementSection);
        if (loggedUser.department.id === 5)
            populateSupReim(reimbursements, reimbursementSection);
        if (loggedUser.department.id === 4)
            populateHeaReim(reimbursements, reimbursementSection);
        if (loggedUser.department.id === 2)
            populateBenReim(reimbursements, reimbursementSection);
        if (loggedUser.department.id === 3)
            populateBSuReim(reimbursements, reimbursementSection);
    }
}
function populateEmpReim(reimbursements, reimbursementSection) {
    if (reimbursements.length > 0) {
        let table = document.createElement('table');

        table.innerHTML = `
        <tr>
            <th>Employee Username</th>
            <th>Date</th>
            <th>Location</th>
            <th>Description</th>
            <th>Event Cost</th>
            <th>Grade Format</th>
            <th>Event Type</th>
            <th>Coverage</th>
            <th>Justification</th>
            <th>Attatchments</th>
            <th>Approval Level</th>
        </tr>
    `;

        for (let reimbursement of reimbursements) {
            if (loggedUser.id === reimbursement.employeeId.id)
                if (reimbursement.approval >= 0) {
                    let coverage = '';
                    switch (reimbursement.event.id) {
                        case 1:
                            coverage = '80%';
                            break;
                        case 2:
                            coverage = '60%';
                            break;
                        case 3:
                            coverage = '75%';
                            break;
                        case 4:
                            coverage = '100%';
                            break;
                        case 5:
                            coverage = '90%';
                            break;
                        case 6:
                            coverage = '30%';
                            break;
                        default:
                            coverage = '30%';
                            break;

                    }
                    let tr = document.createElement('tr');
                    let approvalStage = '';
                    switch (reimbursement.approval) {
                        case -1:
                            approvalStage = 'Denied';
                            break;
                        case 0:
                            approvalStage = 'Pending';
                            break;
                        case 1:
                            approvalStage = 'Direct Supervisor Approved';
                            break;
                        case 2:
                            approvalStage = 'Department Head Approved';
                            break;
                        case 3:
                            approvalStage = 'Benefits Coordinator Approved';
                            break;
                    }
                    //let d = new Date();
                    //d.setDate(reimbursement.date);
                    d=new Date (reimbursement.date).toDateString();//.toISOString();//d.setUTCDate(reimbursement.date);
                    tr.innerHTML = `
                    <td>${reimbursement.employeeId.username}</td>
                    <td>${d}</td>
                    <td>${reimbursement.location}</td>
                    <td>${reimbursement.description}</td>
                    <td>${reimbursement.eventCost}</td>
                    <td>${reimbursement.format.format}</td>
                    <td>${reimbursement.event.format}</td>
                    <td>${coverage}</td>
                    <td>${reimbursement.justification}</td>
                    <td><a href="" id="saveByteArrayA" download>Download</a></td>
                    <td>${approvalStage}</td>`;


                    table.appendChild(tr);
                }
        }

        reimbursementSection.appendChild(table);
    } else {
        reimbursementSection.innerHTML = 'You don\'t have any reimbursements.';
    }

}
function populateSupReim(reimbursements, reimbursementSection) {
    if (reimbursements.length > 0) {
        let table = document.createElement('table');

        table.innerHTML = `
        <tr>
            <th>Employee Username</th>
            <th>Date</th>
            <th>Location</th>
            <th>Description</th>
            <th>Event Cost</th>
            <th>Grade Format</th>
            <th>Event Type</th>
            <th>Coverage</th>
            <th>Justification</th>
            <th>Attatchments</th>
            <th>Approval Level</th>
        </tr>
    `;

        for (let reimbursement of reimbursements) {
            if (loggedUser.id === reimbursement.employeeId.directSupervisor.id)
                if (reimbursement.approval === 0) {
                    let coverage = '';
                    switch (reimbursement.event.id) {
                        case 1:
                            coverage = '80%';
                            break;
                        case 2:
                            coverage = '60%';
                            break;
                        case 3:
                            coverage = '75%';
                            break;
                        case 4:
                            coverage = '100%';
                            break;
                        case 5:
                            coverage = '90%';
                            break;
                        case 6:
                            coverage = '30%';
                            break;
                        default:
                            coverage = '30%';
                            break;

                    }
                    let tr = document.createElement('tr');
                    let approvalStage = '';
                    switch (reimbursement.approval) {
                        case -1:
                            approvalStage = 'Denied';
                            break;
                        case 0:
                            approvalStage = 'Pending';
                            break;
                        case 1:
                            approvalStage = 'Direct Supervisor Approved';
                            break;
                        case 2:
                            approvalStage = 'Department Head Approved';
                            break;
                        case 3:
                            approvalStage = 'Benefits Coordinator Approved';
                            break;
                    }
                    let d=new Date (reimbursement.date).toDateString();
                    let da=new Date (reimbursement.date).getUTCDate();//.toDateString();//.toISOString();//d.setUTCDate(reimbursement.date);
                    let n=new Date().getUTCDate();
                    //console.log(d-n);
                    var Difference_In_Days = da- n; 
                      console.log(Difference_In_Days);
                    // To calculate the no. of days between two dates 
                    //var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24); 
                    if (Difference_In_Days < 14) {
                        tr.innerHTML = `
                    <td style="color:#FF0000">${reimbursement.employeeId.username}</td>
                    <td style="color:#FF0000">${d}</td>
                    <td style="color:#FF0000">${reimbursement.location}</td>
                    <td style="color:#FF0000">${reimbursement.description}</td>
                    <td style="color:#FF0000">${reimbursement.eventCost}</td>
                    <td style="color:#FF0000">${reimbursement.format.format}</td>
                    <td style="color:#FF0000">${reimbursement.event.format}</td>
                    <td style="color:#FF0000">${coverage}</td>
                    <td style="color:#FF0000">${reimbursement.justification}</td>
                    <td><a href="" id="saveByteArrayA" download>Download</a></td>
                    <td style="color:#FF0000">${approvalStage}</td>
                    
                    <button class="message" id="${reimbursement.id}">Message User</button>
                    <button class="approve" id="${reimbursement.id}">Approve</button>
                    <button class="deny" id="${reimbursement.id}">Deny</button>
                `;
                    } else {
                        tr.innerHTML = `
                        <td>${reimbursement.employeeId.username}</td>
                    <td>${d}</td>
                    <td>${reimbursement.location}</td>
                    <td>${reimbursement.description}</td>
                    <td>${reimbursement.eventCost}</td>
                    <td>${reimbursement.format.format}</td>
                    <td>${reimbursement.event.format}</td>
                    <td>${coverage}</td>
                    <td>${reimbursement.justification}</td>
                    <td><a href="" id="saveByteArrayA" download>Download</a></td>
                    <td>${approvalStage}</td>
                    <button class="message" id="${reimbursement.id}">Message</button>
                    <button class="approve" id="${reimbursement.id}">Approve</button>
                    <button class="deny" id="${reimbursement.id}">Deny</button>
                `;
                    }
                    table.appendChild(tr);
                }
        }

        reimbursementSection.appendChild(table);
    } else {
        reimbursementSection.innerHTML = 'You don\'t have any reimbursements.';
    }

}
function populateHeaReim(reimbursements, reimbursementSection) {
    if (reimbursements.length > 0) {
        let table = document.createElement('table');

        table.innerHTML = `
        <tr>
            <th>Employee Username</th>
            <th>Date</th>
            <th>Location</th>
            <th>Description</th>
            <th>Event Cost</th>
            <th>Grade Format</th>
            <th>Event Type</th>
            <th>Coverage</th>
            <th>Justification</th>
            <th>Attatchments</th>
            <th>Approval Level</th>
        </tr>
    `;

        for (let reimbursement of reimbursements) {
            if (loggedUser.id === reimbursement.employeeId.directSupervisor.directSupervisor.id)
                if (reimbursement.approval === 1) {
                    let coverage = '';
                    switch (reimbursement.event.id) {
                        case 1:
                            coverage = '80%';
                            break;
                        case 2:
                            coverage = '60%';
                            break;
                        case 3:
                            coverage = '75%';
                            break;
                        case 4:
                            coverage = '100%';
                            break;
                        case 5:
                            coverage = '90%';
                            break;
                        case 6:
                            coverage = '30%';
                            break;
                        default:
                            coverage = '30%';
                            break;

                    }
                    let tr = document.createElement('tr');
                    let approvalStage = '';
                    switch (reimbursement.approval) {
                        case -1:
                            approvalStage = 'Denied';
                            break;
                        case 0:
                            approvalStage = 'Pending';
                            break;
                        case 1:
                            approvalStage = 'Direct Supervisor Approved';
                            break;
                        case 2:
                            approvalStage = 'Department Head Approved';
                            break;
                        case 3:
                            approvalStage = 'Benefits Coordinator Approved';
                            break;
                    }
                    let d=new Date (reimbursement.date).toDateString();
                    let da=new Date (reimbursement.date).getUTCDate();//.toDateString();//.toISOString();//d.setUTCDate(reimbursement.date);
                    let n=new Date().getUTCDate();
                    //console.log(d-n);
                    var Difference_In_Days = da- n; 
                      console.log(Difference_In_Days);
                    // To calculate the no. of days between two dates 
                    //var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24); 
                    if (Difference_In_Days < 14) {
                        tr.innerHTML = `
                    <td style="color:#FF0000">${reimbursement.employeeId.username}</td>
                    <td style="color:#FF0000">${d}</td>
                    <td style="color:#FF0000">${reimbursement.location}</td>
                    <td style="color:#FF0000">${reimbursement.description}</td>
                    <td style="color:#FF0000">${reimbursement.eventCost}</td>
                    <td style="color:#FF0000">${reimbursement.format.format}</td>
                    <td style="color:#FF0000">${reimbursement.event.format}</td>
                    <td style="color:#FF0000">${coverage}</td>
                    <td style="color:#FF0000">${reimbursement.justification}</td>
                    <td><a href="" id="saveByteArrayA" download>Download</a></td>
                    <td style="color:#FF0000">${approvalStage}</td>
                    <button class="message" id="${reimbursement.id}">Message User</button>
                    <button class="approve" id="${reimbursement.id}">Approve</button>
                    <button class="deny" id="${reimbursement.id}">Deny</button>
                    <button class="messageSupe" id="${reimbursement.employeeId.directSupervisor.id}">Message Supervisor</button>
                    `

                    } else {
                        tr.innerHTML = `
                        <td>${reimbursement.employeeId.username}</td>
                    <td>${d}</td>
                    <td>${reimbursement.location}</td>
                    <td>${reimbursement.description}</td>
                    <td>${reimbursement.eventCost}</td>
                    <td>${reimbursement.format.format}</td>
                    <td>${reimbursement.event.format}</td>
                    <td>${coverage}</td>
                    <td>${reimbursement.justification}</td>
                    <td><a href="" id="saveByteArrayA" download>Download</a></td>
                    <td>${approvalStage}</td>
                    <button class="message" id="${reimbursement.id}">Message</button>
                    <button class="approve" id="${reimbursement.id}">Approve</button>
                    <button class="deny" id="${reimbursement.id}">Deny</button>
                    <button class="messageSupe" id="${reimbursement.employeeId.directSupervisor.id}">Message Supervisor</button>
                    `

                    }
                    table.appendChild(tr);
                }
        }

        reimbursementSection.appendChild(table);
    } else {
        reimbursementSection.innerHTML = 'You don\'t have any reimbursements.';
    }

}
function populateBenReim(reimbursements, reimbursementSection) {
    if (reimbursements.length > 0) {
        let table = document.createElement('table');

        table.innerHTML = `
        <tr>
            <th>Employee Username</th>
            <th>Date</th>
            <th>Location</th>
            <th>Description</th>
            <th>Event Cost</th>
            <th>Grade Format</th>
            <th>Event Type</th>
            <th>Coverage</th>
            <th>Justification</th>
            <th>Attatchments</th>
            <th>Approval Level</th>
        </tr>
    `;

        for (let reimbursement of reimbursements) {
            if (loggedUser.id === reimbursement.employeeId.directSupervisor.directSupervisor.directSupervisor.id)

                if (reimbursement.approval === 2) {
                    let coverage = '';
                    switch (reimbursement.event.id) {
                        case 1:
                            coverage = '80%';
                            break;
                        case 2:
                            coverage = '60%';
                            break;
                        case 3:
                            coverage = '75%';
                            break;
                        case 4:
                            coverage = '100%';
                            break;
                        case 5:
                            coverage = '90%';
                            break;
                        case 6:
                            coverage = '30%';
                            break;
                        default:
                            coverage = '30%';
                            break;

                    }
                    let tr = document.createElement('tr');
                    let approvalStage = '';
                    switch (reimbursement.approval) {
                        case -1:
                            approvalStage = 'Denied';
                            break;
                        case 0:
                            approvalStage = 'Pending';
                            break;
                        case 1:
                            approvalStage = 'Direct Supervisor Approved';
                            break;
                        case 2:
                            approvalStage = 'Department Head Approved';
                            break;
                        case 3:
                            approvalStage = 'Benefits Coordinator Approved';
                            break;
                    }
                    let d=new Date (reimbursement.date).toDateString();
                    let da=new Date (reimbursement.date).getUTCDate();//.toDateString();//.toISOString();//d.setUTCDate(reimbursement.date);
                    let n=new Date().getUTCDate();
                    //console.log(d-n);
                    var Difference_In_Days = da- n; 
                      console.log(Difference_In_Days);
                    // To calculate the no. of days between two dates 
                    //var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24); 
                    if (Difference_In_Days < 14) {
                        tr.innerHTML = `
                    <td style="color:#FF0000">${reimbursement.employeeId.username}</td>
                    <td style="color:#FF0000">${d}</td>
                    <td style="color:#FF0000">${reimbursement.location}</td>
                    <td style="color:#FF0000">${reimbursement.description}</td>
                    <td style="color:#FF0000">${reimbursement.eventCost}</td>
                    <td style="color:#FF0000">${reimbursement.format.format}</td>
                    <td style="color:#FF0000">${reimbursement.event.format}</td>
                    <td style="color:#FF0000">${coverage}</td>
                    <td style="color:#FF0000">${reimbursement.justification}</td>
                    <td><a href="" id="saveByteArrayA" download>Download</a></td>
                    <td style="color:#FF0000">${approvalStage}</td>
                    <button class="message" id="${reimbursement.id}">Message User</button>
                    <button class="approve" id="${reimbursement.id}">Approve</button>
                    <button class="deny" id="${reimbursement.id}">Deny</button>
                    <button class="messageSupe" id="${reimbursement.employeeId.directSupervisor.id}">Message Supervisor</button>
                    <button class="messageSupe" id="${reimbursement.employeeId.directSupervisor.directSupervisor.id}">Message Head</button>
                    <button class="alterAmount" id="${reimbursement.id}">Alter Amount</button>
                    `;
                    }else{
                        tr.innerHTML = `
                        <td>${reimbursement.employeeId.username}</td>
                    <td>${d}</td>
                    <td>${reimbursement.location}</td>
                    <td>${reimbursement.description}</td>
                    <td>${reimbursement.eventCost}</td>
                    <td>${reimbursement.format.format}</td>
                    <td>${reimbursement.event.format}</td>
                    <td>${coverage}</td>
                    <td>${reimbursement.justification}</td>
                    <td><a href="" id="saveByteArrayA" download>Download</a></td>
                    <td>${approvalStage}</td>
                    <button class="message" id="${reimbursement.id}">Message User</button>
                    <button class="approve" id="${reimbursement.id}">Approve</button>
                    <button class="deny" id="${reimbursement.id}">Deny</button>
                    <button class="messageSupe" id="${reimbursement.employeeId.directSupervisor.id}">Message Supervisor</button>
                    <button class="messageSupe" id="${reimbursement.employeeId.directSupervisor.directSupervisor.id}">Message Head</button>
                    <button class="alterAmount" id="${reimbursement.id}">Alter Amount</button>
                    `;

                    }
                    table.appendChild(tr);
                }
        }

        reimbursementSection.appendChild(table);
    } else {
        reimbursementSection.innerHTML = 'You don\'t have any reimbursements.';
    }

}
function populateBSuReim(reimbursements, reimbursementSection) {
    if (reimbursements.length > 0) {
        let table = document.createElement('table');

        table.innerHTML = `
        <tr>
            <th>Employee Username</th>
            <th>Date</th>
            <th>Location</th>
            <th>Description</th>
            <th>Event Cost</th>
            <th>Grade Format</th>
            <th>Event Type</th>
            <th>Coverage</th>
            <th>Justification</th>
            <th>Attatchments</th>
            <th>Approval Level</th>
        </tr>
    `;

        for (let reimbursement of reimbursements) {
            if (loggedUser.id === reimbursement.employeeId.id)
                if (reimbursement.approval >= 3) {
                    let coverage = '';
                    switch (reimbursement.event.id) {
                        case 1:
                            coverage = '80%';
                            break;
                        case 2:
                            coverage = '60%';
                            break;
                        case 3:
                            coverage = '75%';
                            break;
                        case 4:
                            coverage = '100%';
                            break;
                        case 5:
                            coverage = '90%';
                            break;
                        case 6:
                            coverage = '30%';
                            break;
                        default:
                            coverage = '30%';
                            break;

                    }
                    let tr = document.createElement('tr');
                    let approvalStage = '';
                    switch (reimbursement.approval) {
                        case -1:
                            approvalStage = 'Denied';
                            break;
                        case 0:
                            approvalStage = 'Pending';
                            break;
                        case 1:
                            approvalStage = 'Direct Supervisor Approved';
                            break;
                        case 2:
                            approvalStage = 'Department Head Approved';
                            break;
                        case 3:
                            approvalStage = 'Benefits Coordinator Approved';
                            break;
                    }
                    let d=new Date (reimbursement.date).toDateString();
                    let da=new Date (reimbursement.date).getUTCDate();//.toDateString();//.toISOString();//d.setUTCDate(reimbursement.date);
                    let n=new Date().getUTCDate();
                    //console.log(d-n);
                    var Difference_In_Days = da- n; 
                      console.log(Difference_In_Days);
                    // To calculate the no. of days between two dates 
                    //var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24); 
                    if (Difference_In_Days < 14) {
                        tr.innerHTML = `
                    <td style="color:#FF0000">${reimbursement.employeeId.username}</td>
                    <td style="color:#FF0000">${d}</td>
                    <td style="color:#FF0000">${reimbursement.location}</td>
                    <td style="color:#FF0000">${reimbursement.description}</td>
                    <td style="color:#FF0000">${reimbursement.eventCost}</td>
                    <td style="color:#FF0000">${reimbursement.format.format}</td>
                    <td style="color:#FF0000">${reimbursement.event.format}</td>
                    <td style="color:#FF0000">${coverage}</td>
                    <td style="color:#FF0000">${reimbursement.justification}</td>
                    <td style="color:#FF0000">${approvalStage}</td>
                `;
                    }else{
                        tr.innerHTML = `
                    <td >${reimbursement.employeeId.username}</td>
                    <td >${d}</td>
                    <td >${reimbursement.location}</td>
                    <td >${reimbursement.description}</td>
                    <td >${reimbursement.eventCost}</td>
                    <td >${reimbursement.format.format}</td>
                    <td >${reimbursement.event.format}</td>
                    <td >${coverage}</td>
                    <td >${reimbursement.justification}</td>
                    <td >${approvalStage}</td>
                `;

                    }
                    table.appendChild(tr);
                }
        }

        reimbursementSection.appendChild(table);
    } else {
        reimbursementSection.innerHTML = 'You don\'t have any reimbursements.';
    }

}
function saveByteArray(reportName, byte) {
    var blob = new Blob([byte], { type: "application/pdf" });
    var link = document.getElementById('saveByteArrayA');
    link.href = window.URL.createObjectURL(blob);
    var fileName = reportName;
    link.download = fileName;
    link.click();
};
//ADD EVENT LISTENERS FOR BUTTONS
(function (doc) {
    var cb_addEventListener = function (obj, evt, fnc) {
        // W3C model
        if (obj.addEventListener) {
            obj.addEventListener(evt, fnc, false);
            return true;
        }
        // Microsoft model
        else if (obj.attachEvent) {
            return obj.attachEvent('on' + evt, fnc);
        }
        // Browser don't support W3C or MSFT model, go on with traditional
        else {
            evt = 'on' + evt;
            if (typeof obj[evt] === 'function') {
                // Object already has a function on traditional
                // Let's wrap it with our own function inside another function
                fnc = (function (f1, f2) {
                    return function () {
                        f1.apply(this, arguments);
                        f2.apply(this, arguments);
                    }
                })(obj[evt], fnc);
            }
            obj[evt] = fnc;
            return true;
        }
        return false;
    };
    var hasClass = function (el, className) {
        return (' ' + el.className + ' ').indexOf(' ' + className + ' ') > -1;
    }

    cb_addEventListener(doc, 'click', function (e) {
        if (hasClass(e.target, 'message')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            message.call(e.target, e);
        }
        if (hasClass(e.target, 'messageConfirmReply')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            messageConfirmReply.call(e.target, e);
        }
        if (hasClass(e.target, 'messageView')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            messageView.call(e.target, e);
        }
        if (hasClass(e.target, 'messageReply')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            messageReply.call(e.target, e);
        }
        if (hasClass(e.target, 'messageConfirm')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            messageConfirm.call(e.target, e);
        }
        if (hasClass(e.target, 'reimburseConfirm')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            reimburseConfirm.call(e.target, e);
        }
        if (hasClass(e.target, 'approve')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            approve.call(e.target, e);
        }
        if (hasClass(e.target, 'deny')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            deny.call(e.target, e);
        }
        if (hasClass(e.target, 'messageSupe')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            messageSupe.call(e.target, e);
        }
        if (hasClass(e.target, 'alterAmount')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            alterAmount.call(e.target, e);
        }
        if (hasClass(e.target, 'changeAmt')) {
            e.preventDefault ? e.preventDefault() : e.returnValue = false;
            changeAmt.call(e.target, e);
        }
    });
})(document);
function alterAmount(event) {
    //alert(this.id); // this will be the clicked element
    //this will be when they clicked the deny button
    alterAmountPre(this.id);
}
let editingReimb = null;
async function alterAmountPre(reimbId) {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/reimburse/';
    url += reimbId;
    let response = await fetch(url, { method: 'GET' });

    switch (response.status) {
        case 200: // successful
            let reimb = await response.json();
            editingReimb=reimb;
            alterReimbForm(reimb);
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            break;
        case 404: // user not found
            alert('TESTING That user does not exist.');
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
function alterReimbForm(reimbursement) {
    // http://localhost:8080/users?user=sierra&pass=pass
    let reimbursementSection = document.getElementById('reimbursementSection');
    reimbursementSection.innerHTML = `
        <label for="changeAmt">Change Amount To:</label><br>
        <input type="number" name="changeAmt" id="changeAmt" required ></textarea>
    <br>
    <button class="changeAmt" id="changeAmt" type="button">
        Submit Message
    </button>
`;

}
let from=null;
let to=null;
let content=null;
async function alterReimbAmt(reimbursement) {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/reimburse/';
    url += reimbursement.id;
    console.log(reimbursement);
    reimbursement.eventCost = document.getElementById("changeAmt").value;
    if (reimbursement.eventCost > 1000) {
        reimbursement.justification += "  BENCO APPROVED TO EXCEED AVAILABLE FUNDS"
    }
    from=loggedUser;
    to=reimbursement.employeeId;
    content = "BENCO APPROVED AMOUNT ADJUSTED: "+ reimbursement.eventCost;
    let response = await fetch(url, { method: 'PUT', body: JSON.stringify(reimbursement) });
    switch (response.status) {
        case 200: // successful
            messageAfterAlter(loggedUser,reimbursement.employeeId,content)
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            break;
        case 404: // user not found
            alert('TESTING That user does not exist.');
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
async function updateUserAfter(user){
    let url = baseUrl + '/user/';
    url += user.id;
    user.reimbursementClaimed += document.getElementById("changeAmt").value;
    let response = await fetch(url, { method: 'PUT', body: JSON.stringify(user) });
    switch (response.status) {
        case 200: // successful
            console.log("success");
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            break;
        case 404: // user not found
            alert('TESTING That user does not exist.');
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
function changeAmt(event) {
    //alert(this.id); // this will be the clicked element
    //this will be when they clicked the deny button
    alterReimbAmt(editingReimb);
    messageAfterAlter(this.id);
}
async function messageAfterAlter(i){

    let url = baseUrl + '/message';
    let message = {};
    message.id = 0;
    message.from = from;
    message.to = to;
    message.content = content;
    let response = await fetch(url, { method: 'POST', body: JSON.stringify(message) });
    if (response.status === 201) {
        alert('Added Message successfully.');
    } else {
        alert('Something went wrong.');
    }
}
//UPDATE http://localhost:8080/TRMS/reimburse/45
function messageSupe(event) {
    //alert(this.id); // this will be the clicked element
    //this will be when they clicked the deny button
    messageSupeQ(this.id);
}
async function messageSupeQ(userId) {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/user/';
    url += userId;
    console.log(userId);
    let response = await fetch(url, { method: 'GET' });
    
    switch (response.status) {
        case 200: // successful
            let supe = await response.json();
            messageSuper(supe);
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            break;
        case 404: // user not found
            alert('TESTING That user does not exist.');
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
function messageSuper(messagee) {
    let reimbursementSection = document.getElementById('reimbursementSection');
    messageUser = messagee;
    reimbursementSection.innerHTML = `
        FROM: ${loggedUser.username}
        <br>
        TO: ${messagee.username}
        <br>
        <label for="Content">Content</label><br>
        <textarea name="Content" cols="80" rows="10" id="Content" required ></textarea>
    <br>
    <button class="messageConfirm" id="messageConfirm" onclick="messageConfirm" type="button">
        Submit Message
    </button>
`;
}
//UPDATE http://localhost:8080/TRMS/reimburse/45
function deny(event) {
    //alert(this.id); // this will be the clicked element
    //this will be when they clicked the deny button
    denyReimbursee(this.id);
}
async function denyReimbursee(deniedId) {
    let reimbursements = allReimbursements;
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/reimburse/';
    url += deniedId;
    let deniedReimburse = null;
    for (let reimbursement of reimbursements) {
        console.log(reimbursement.id);
        if (reimbursement.id == deniedId) {
            reimbursement.approval = -1;
            deniedReimburse = reimbursement;
            console.log("madeit");
            break;
        }
    }
    let response = await fetch(url, { method: 'PUT', body: JSON.stringify(deniedReimburse) });

    switch (response.status) {
        case 200: // successful
            messageDeny(deniedReimburse);
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            break;
        case 404: // user not found
            alert('TESTING That user does not exist.');
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
//POST http://localhost:8080/TRMS/message
function message(event) {
    let reimbursements = allReimbursements;
    let messageReimburse = null;
    for (let reimbursement of reimbursements) {
        if (reimbursement.id == this.id) {
            messageReimburse = reimbursement;
            messageUser = messageReimburse.employeeId;
            break;
        }
    }
    let reimbursementSection = document.getElementById('reimbursementSection');
    reimbursementSection.innerHTML = `
        FROM: ${loggedUser.username}
        <br>
        TO: ${messageReimburse.employeeId.username}
        <br>
        <label for="Content">Content</label><br>
        <textarea name="Content" cols="80" rows="10" id="Content" required ></textarea>
    <br>
    <button class="messageConfirm" id="messageConfirm" onclick="messageConfirm" type="button">
        Submit Message
    </button>
`;
}
function messageDeny(deniedReimburse) {
    let reimbursementSection = document.getElementById('reimbursementSection');
    messageUser = deniedReimburse.employeeId;
    reimbursementSection.innerHTML = `
        FROM: ${loggedUser.username}
        <br>
        TO: ${deniedReimburse.employeeId.username}
        <br>
        <label for="Content">Content</label><br>
        <textarea name="Content" cols="80" rows="10" id="Content" required ></textarea>
    <br>
    <button class="messageConfirm" id="messageConfirm" onclick="messageConfirm" type="button">
        Submit Message
    </button>
`;
}
async function messageConfirm() {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/message';
    console.log(messageUser);
    let message = {};
    message.id = 0;
    message.from = loggedUser;
    message.to = messageUser;
    message.content = document.getElementById('Content').value;
    console.log("made it to message confirm");
    let response = await fetch(url, { method: 'POST', body: JSON.stringify(message) });
    if (response.status === 201) {
        alert('Added Message successfully.');
    } else {
        alert('Something went wrong.');
    }

}
//UPDATE http://localhost:8080/TRMS/reimburse/45
function approve(event) {
    //alert(this.id); // this will be the clicked element
    //this will be when they clicked the approve button
    approveReimbursement(this.id);
}
async function approveReimbursement(approvedId) {
    let reimbursements = allReimbursements;
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/reimburse/';
    url += approvedId;
    let approvedReimburse = null;
    for (let reimbursement of reimbursements) {
        console.log(reimbursement.id);
        if (reimbursement.id == approvedId) {
            reimbursement.approval += 1;
            approvedReimburse = reimbursement;
            console.log("madeit");
            break;
        }
    }
    let response = await fetch(url, { method: 'PUT', body: JSON.stringify(approvedReimburse) });

    switch (response.status) {
        case 200: // successful
            populateReimbursements()
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            break;
        case 404: // user not found
            alert('TESTING That user does not exist.');
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
//POST http://localhost:8080/TRMS/reimburse
function createReimburse() {
    let today = new Date();
    let dd = String(today.getDate() + 7).padStart(2, '0');
    let mm = String(today.getMonth() + 1).padStart(2, '0');
    let yy = today.getFullYear();
    today = yy + "-" + mm + "-" + dd;
    let reimbursementSection = document.getElementById('reimbursementSection');//EMPLOYEE ID WILL BE JUST USER
    reimbursementSection.innerHTML = `
        <br>
        <label for="Date">Event date:</label>
        <input type="date" id="Date" name="Date"
               value=${today}
               min=${today} required>

        <br>
        <label for="Location">Location</label>
        <input type="text" name="Location" id="Location"  required/>
        <br>
        <label for="Description">Description</label>
        <input type="text" name="Description" id="Description"  required/>
        <br>
        <label for="Event">Event Type</label>
        <select name="Event" id="Event"  >
            <option value="1">UNIVERSITY COURSES</option>
            <option value="2">SEMINARS</option>
            <option value="3">CERTIFICATION PREPARATION CLASSES</option>
            <option value="4">CERTIFICATION</option>
            <option value="5">TECHNICAL TRAINING</option>
            <option value="6">OTHER</option>
        </select>
        <br>
        <label for="myInputCost">Event Cost</label>
        <input type="text" id="myInputCost" name="myInputCost" oninput="myFunction()" required>
        <br>

        <label for="Format">Grading Format</label>
        <select name="Format" id="Format"  >
            <option value="1">GRADE</option>
            <option value="2">PRESENTATION</option>
        </select>

        <br>
        <label for="Justification">Justification</label>
        <input type="text" name="Justification" id="Justification"  required/>
        <br>

        <label for="Attatchments">Select Attatchments (.pdf, .png, .jpeg, .txt, or .doc only):</label>
        <input type="file" id="Attatchments" name="Attatchments" accept=".pdf,.png,.jpeg,.txt,.doc" multiple>
        <br>

        <label for="Attatchments2">Have an Approval Email? (.msg only):</label>
        <input type="file" id="Attatchments2" name="Attatchments2" accept=".msg" multiple>


    <br>
    <p id="demo"></p>

    <button class="reimburseConfirm" id="reimburseConfirm" onclick="reimburseConfirm" type="button">
        Submit Reimbursement
    </button>
    
`;
}
let amt = 0;
function myFunction() {
    let x = 0;
    x = document.getElementById("myInputCost").value;
    let e = 0.3;
    let percent = '';
    console.log(document.getElementById("Event").value);
    switch (document.getElementById("Event").value) {
        case '1':
            e = 0.8;
            percent = '80%';
            break;
        case '2':
            e = 0.6;
            percent = '60%';
            break;
        case '3':
            e = 0.75;
            percent = '75%';
            break;
        case '4':
            e = 1;
            percent = '100%';
            break;
        case '5':
            e = 0.9;
            percent = '90%';
            break;
        case '6':
            e = 0.3;
            percent = '30%';
            break;
        default:
            e = 0.3;
            percent = '30%';
            break;
    }

    let r = 0;
    for (let reimbursement of allReimbursements) {
        if(reimbursement.approval!=-1)
        if (reimbursement.employeeId.id === loggedUser.id) {
            r += reimbursement.eventCost;
        }
    }
    let availableReimbursement = 1000 - r - loggedUser.reimbursementClaimed;
    if (x * e > availableReimbursement) {
        amt = availableReimbursement;
    } else {
        amt = x * e;
    }
    if(amt<0){
        amt=0;
    }
    document.getElementById("demo").innerHTML = "Projected Reimbursement (" + percent + "):  " + amt;
}
async function reimburseConfirm() {
    // http://localhost:8080/users?user=sierra&pass=pass
    console.log(document.getElementById('Date').valueAsNumber);
    let selectedFile = document.getElementById('Attatchments').files[0];
    let fileByteArray = [];
    if (selectedFile != null) {
        let reader = new FileReader();
        reader.readAsArrayBuffer(selectedFile);
        reader.onloadend = function (evt) {
            if (evt.target.readyState == FileReader.DONE) {
                var arrayBuffer = evt.target.result,
                    array = new Uint8Array(arrayBuffer);
                for (var i = 0; i < array.length; i++) {
                    fileByteArray.push(array[i]);
                }
            }
        }
    }

    //const selectedFile2 = document.getElementById('Attatchments2').files[0];
    let url = baseUrl + '/reimburse';
    let reimbursement = {};
    reimbursement.employeeId = loggedUser;
    reimbursement.date = document.getElementById('Date').valueAsNumber;
    reimbursement.location = document.getElementById('Location').value;
    reimbursement.description = document.getElementById('Description').value;
    reimbursement.eventCost = amt;
    reimbursement.format = {};
    reimbursement.event = {};
    let v = document.getElementById('Format').value;
    switch (v) {//CHANGE THIS TO A DROP DOWN BOX
        case '1': // successful
            reimbursement.format.id = 1;
            reimbursement.format.format = 'GRADE';
            break;
        case '2': // incorrect password
            reimbursement.format.id = 2;
            reimbursement.format.format = 'PRESENTATION';
            break;
        default: // other error
            reimbursement.format.id = 1;
            reimbursement.format.format = 'GRADE';
            break;
    }
    //reimbursement.format = document.getElementById('Format').value;
    v = document.getElementById('Event').value;
    switch (v) {//CHANGE THIS TO A DROP DOWN BOX
        case '1': // successful
            reimbursement.event.id = 1;
            reimbursement.event.format = 'UNIVERSITY COURSES';
            break;
        case '2': // incorrect password
            reimbursement.event.id = 2;
            reimbursement.event.format = 'SEMINARS';
            break;
        case '3': // successful
            reimbursement.event.id = 3;
            reimbursement.event.format = 'CERTIFICATION PREPARATION CLASSES';
            break;
        case '4': // incorrect password
            reimbursement.event.id = 4;
            reimbursement.event.format = 'CERTIFICATION';
            break;
        case '5': // successful
            reimbursement.event.id = 5;
            reimbursement.event.format = 'TECHNICAL TRAINING';
            break;
        case '6': // incorrect password
            reimbursement.event.id = 6;
            reimbursement.event.format = 'OTHER';
            break;
        default: // other error
            reimbursement.event.id = 6;
            reimbursement.event.format = 'OTHER';
            break;
    }
    reimbursement.justification = document.getElementById('Justification').value;
    reimbursement.attatchments = fileByteArray;//document.getElementById('Attatchments').value;
    let outlookEmail = document.getElementById('Attatchments2').value;
    reimbursement.approval = 0;
    if (outlookEmail != "") {
        reimbursement.approval = 1;
    }
    if (loggedUser.directSupervisor.head === true) {
        reimbursement.approval = 2;
    }
    let response = await fetch(url, { method: 'POST', body: JSON.stringify(reimbursement) });
    if (response.status === 201) {
        alert('Added reimbursement successfully.');
    } else {
        alert('Something went wrong.');
    }

}
//GET http://localhost:8080/TRMS/user/15  GET BY ID
//GET http://localhost:8080/TRMS/message  GET ALL MESSAGE
let allMessages = null;
async function fetchMessages() {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/message';
    let response = await fetch(url, { method: 'GET' });

    switch (response.status) {
        case 200: // successful
            allMessages = await response.json();
            setNav();
            populateMessages();
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
function populateMessages() {
    if (loggedUser) {
        let messages = allMessages;
        let messageSection = document.getElementById('reimbursementSection');

        if (messages.length > 0) {
            let table = document.createElement('table');

            table.innerHTML = `
                <tr>
                    <th>Message ID</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Content</th>
                </tr>
            `;

            for (let message of messages) {
                if (message.to.username === loggedUser.username) {
                    let tr = document.createElement('tr');
                    tr.innerHTML = `
                        <td>${message.id}</td>
                        <td>${message.from.username}</td>
                        <td>${message.to.username}</td>
                        <td>${message.content}</td>
                        <button class="messageView" id="${message.id}">View</button>
                        <button class="messageReply" id="${message.id}">Reply</button>
                    `;
                    table.appendChild(tr);
                }
            }
            messageSection.innerHTML = ``;
            messageSection.appendChild(table);
        } else {
            messageSection.innerHTML = 'You don\'t have any messages.';
        }
    }
}
//GET http://localhost:8080/TRMS/message/10  GET MESSAGE BY ID
function messageView(event) {
    //alert(this.id); // this will be the clicked element
    //this will be when they clicked the approve button
    messageViewDisplay(this.id);
}
async function messageViewDisplay(approvedId) {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/message/';
    url += approvedId;
    let response = await fetch(url, { method: 'GET' });

    switch (response.status) {
        case 200: // successful
            let mess = await response.json();
            displayMessage(mess);
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            break;
        case 404: // user not found
            alert('TESTING That user does not exist.');
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
let messageUserReply = null;
function displayMessage(message) {
    //console.log(message);
    let reimbursementSection = document.getElementById('reimbursementSection');
    reimbursementSection.innerHTML = ``;
    let from = document.createElement('p');
    let to = document.createElement('p');
    let content = document.createElement('p');
    let button = document.createElement('button');
    messageUserReply = message.from;

    button.innerHTML = `<button class="messageReply" id="${message.id}">Reply</button>`;
    from.innerHTML = `<h2>FROM:</h2><h3>${message.from.username}</h3><br>`;
    to.innerHTML = `<h2>To:</h2><h3>${message.to.username}</h3><br>`;
    content.innerHTML = `<h2>Content:</h2><h3>${message.content}</h3><br>`;
    reimbursementSection.appendChild(button);
    reimbursementSection.appendChild(from);
    reimbursementSection.appendChild(to);
    reimbursementSection.appendChild(content);
}
function messageReply(event) {
    //alert(this.id); // this will be the clicked element
    //this will be when they clicked the deny button
    messageReplying(this.id);
}
async function messageReplying(messageId) {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/message/';
    url += messageId;
    let response = await fetch(url, { method: 'GET' });
    let mess = null;
    switch (response.status) {
        case 200: // successful
            mess = await response.json();
            messageUserReply = mess;
            console.log(mess);
            let reimbursementSection = document.getElementById('reimbursementSection');
            reimbursementSection.innerHTML = `
                FROM: ${loggedUser.username}
                <br>
                TO: ${mess.from.username}
                <br>
                <label for="Content">Content</label><br>
                <textarea name="Content" cols="80" rows="10" id="Content" required ></textarea>
                <br>
                <button class="messageConfirmReply" id="messageConfirmReply" onclick="messageConfirmReply" type="button">
                    Submit Message
                </button>
                `;
            break;
        case 400: // incorrect password
            alert('Incorrect password, try again.');
            break;
        case 404: // user not found
            alert('TESTING That user does not exist.');
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }

}
async function messageConfirmReply() {
    // http://localhost:8080/users?user=sierra&pass=pass
    let url = baseUrl + '/message';
    let message = {};
    message.id = 0;
    message.from = loggedUser;
    message.to = messageUserReply.from;
    message.content = "RE: " + document.getElementById('Content').value;
    let response = await fetch(url, { method: 'POST', body: JSON.stringify(message) });
    if (response.status === 201) {
        alert('Added Message successfully.');
    } else {
        alert('Something went wrong.');
    }

}
//GET http://localhost:8080/TRMS/reimburse/40  GET REIMBURSE BY ID
//PUT http://localhost:8080/TRMS/reimburse/45 (USER SIDE)  UPDATE REIMBURSEMENT (USER)