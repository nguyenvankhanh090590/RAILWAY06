// Khởi tạo đối tượng Department
function Department(departmentID, departmentName) {
    this.departmentID = departmentID;
    this.departmentName = departmentName;
}

// Tạo 5 bản ghi
var dept1 = new Department(1, "CEO");
var dept2 = new Department(2, "Thư ký");
var dept3 = new Department(3, "Giám đốc");
var dept4 = new Department(4, "Nhân sự");
var dept5 = new Department(5, "Sale");

// Đưa 5 bản ghi vào một mảng

var listOfDepts = [dept1, dept2, dept3, dept4, dept5];

// Khởi tạo đối tượng Position
function Position(positionID, x) {
    this.positionID = positionID;
    if (x == 1) {
        this.positionName = "Dev";
    } else if (x == 2) {
        this.positionName = "Test";
    } else if (x == 3) {
        this.positionName = "Scrum Master";
    } else if (x == 4) {
        this.positionName = "PM";
    } else {
        this.positionName = "Undefined";
    }
}
// Tạo 4 đối tượng
var pot1 = new Position(1, 1);
var pot2 = new Position(2, 2);
var pot3 = new Position(3, 3);
var pot4 = new Position(4, 4);

// Đưa các bản ghi vào một mảng
var listOfPositions = [pot1, pot2, pot3, pot4];

function Account(accountID,
    email, userName, fullName, departmentID, positionID, createDate) {
    this.accountID = accountID;
    this.email = email;
    this.fullName = fullName;
    this.userName = userName;
    var bl1 = false;
    for (i = 0; i < listOfDepts.length; i++) {
        if (departmentID == listOfDepts[i].departmentID) {
            this.Department = listOfDepts[i];
            bl1 = true;
        }
    }
    if (bl1 == false) {
        this.Department = "Phòng chờ";
    }

    var bl2 = false;
    for (i = 0; i < listOfPositions.length; i++) {
        if (positionID == listOfPositions[i].positionID) {
            this.Position = listOfPositions[i];
            bl2 = true;
        }
    }
    if (bl2 == false) {
        this.Position = "Chờ việc";
    }
    this.createDate = createDate;
}



// Tạo 5 bản ghi
var acc1 = new Account(1, "VanA@gmail.com", "vana", "Nguyễn Văn A", 1, 1, "2016-11-12");
var acc2 = new Account(2, "VanB@gmail.com", "vanb", "Nguyễn Văn B", 2, 2, "2017-2-3");
var acc3 = new Account(3, "VanC@gmail.com", "vanc", "Nguyễn Văn C", 3, 3, "2018-9-14");
var acc4 = new Account(4, "VanD@gmail.com", "vand", "Nguyễn Văn D", 4, 4, "2019-10-15");
var acc5 = new Account(5, "VanE@gmail.com", "vane", "Nguyễn Văn E", 5, 1, "2020-5-22");

// Đưa các bản ghi vào một mảng
var listOfAccs = [acc1, acc2, acc3, acc4, acc5];

function Group(groupID, groupName, listOfAccsInGr, creatorID, joinDate) {
    this.groupID = groupID;
    this.groupName = groupName;
    this.listOfAccsInGr = listOfAccsInGr;
    this.accounts = [];
    for (i = 0; i < listOfAccsInGr.length; i++) {
        if (listOfAccsInGr[i] <= listOfAccs.length) {
            for (j = 0; j < listOfAccs.length; j++) {
                if (listOfAccsInGr[i] == listOfAccs[j].accountID) {
                    this.accounts.push(listOfAccs[j]);
                }
            }

        } else {
            throw "Account ID " + listOfAccsInGr[i] + " không tồn tại!";
        }
    }
    if (creatorID <= listOfAccs.length) {
        for (j = 0; j < listOfAccs.length; j++) {
            if (creatorID == listOfAccs[j].accountID) {
                this.creator = listOfAccs[j];
            }
        }
    } else {
        throw "Account ID " + listOfAccsInGr[i] + " không tồn tại!";
    }
    this.createDate = joinDate;
}

// Tạo 5 bản ghi
var gr1 = new Group(1, "Cá rán", [1, 2, 3], 1, "2018-12-15");
var gr2 = new Group(2, "Thịt mỡ", [2, 3, 4], 2, "2019-1-24");
var gr3 = new Group(3, "Dưa hành", [3, 4, 5], 3, "2019-2-27");
var gr4 = new Group(4, "Câu đối đỏ", [1, 3, 5], 4, "2020-01-06");

// Đưa các bản ghi vào một mảng
var listOfGrs = [gr1, gr2, gr3, gr4];

// Câu 1: Tạo hàm kiểm tra department của account
function checkDept(accountID) {
    var bl = false;
    var result = "";
    listOfAccs.forEach(acc => {
        if (acc.accountID == accountID) {
            bl = true;
            // Câu 3:    
            result = (acc.Depatment !== null ? "Phòng ban của account với ID = " + accountID + " là: " + acc.Department.departmentName :
                "Nhân viên này chưa có phòng ban");
            // if (acc.Department !== null) {
            //     result = "Phòng ban của account với ID = " + accountID + " là: " + acc.Department.departmentName;
            // } else {
            //     result = "Nhân viên này chưa có phòng ban";
            // }
        }
    });
    if (bl == false) {
        result = "Account không tồn tại";
    }
    document.getElementById("label").innerHTML = result;
}

// Câu 2: Tạo hàm kiểm tra group của account
function checkGr(accountID) {
    var listOfGrOfAcc = [];
    var count = 0;
    var result = "";
    listOfGrs.forEach(gr => {
        var bl = false;
        if (gr.listOfAccsInGr.length !== 0) {
            gr.listOfAccsInGr.forEach(accID => {
                if (accID == accountID) {
                    bl = true;
                    count++;
                }
            });
        }
        if (bl == true) {
            listOfGrOfAcc.push(gr);
        }
    });

    switch (count) {
        case 0:
            result = "Nhân viên này chưa có group";
            break;
        case 1:
            result = "Group của nhân viên này là: " + listOfGrOfAcc[0].groupName;
            break;
        case 2:
            result = "Group của nhân viên này là: " + listOfGrOfAcc[0].groupName + " và " + listOfGrOfAcc[1].groupName;
            break;
        case 3:
            result = "Nhân viên này là người quan trọng, tham gia nhiều group";
            break;
        case 4:
            result = "Nhân viên này là người hóng chuyện, tham gia tất cả các group";
            break;
        default:
            result = "Undefined"
    }

    document.getElementById("lable1").innerHTML = result;
}

// Câu 4: Tạo hàm kiểm tra xe account có phải là Dev không
function checkDev(accountID) {
    var result = "";
    for (i = 0; i < listOfAccs.length; i++) {
        if (listOfAccs[i].accountID !== accountID) {
            continue;
        } else {
            result = (listOfAccs[i].Position.positionName == "Dev" ? "Đây là Developer" :
                "Người này không phải là Developer");
        }
    }
    document.getElementById("lable2").innerHTML = result;
}

// Câu 5: Tạo hàm in ra số lượng members của group1:
function printAmountOfEmpls(groupID) {
    var result = 0;
    var txt = "";
    for (i = 0; i < listOfGrs.length; i++) {
        if (listOfGrs[i].groupID == groupID) {
            result = listOfGrs[i].listOfAccsInGr.length;
        }
    }
    switch (result) {
        case 1:
            txt = "Nhóm có một thành viên";
            break;
        case 2:
            txt = "Nhóm có hai thành viên";
            break;
        case 3:
            txt = "Nhóm có ba thành viên";
            break;
        default:
            txt = "Nhóm có nhiều thành viên";
    }
    document.getElementById("amountGr1").value = txt;
}
// Method Câu 1: in ra các số nguyên chẵn nhỏ hơn 10
function showEvenInt() {
    var txt = "";
    for (i = 0; i < 10; i++) {
        if (i % 2 == 0) {
            txt += i + ", ";
        }
    }
    var n = txt.length;
    txt = txt.substring(0, n - 2);
    alert(txt);
}
// Method Câu 2: Tạo method để in ra thông tin các account
function printAcc() {
    var result = "";
    for (i = 0; i < listOfAccs.length; i++) {
        result += "ID = " + listOfAccs[i].accountID + ", Email = " + listOfAccs[i].email + ", Username = " + listOfAccs[i].userName +
            ", FullName = " + listOfAccs[i].fullName + ", Department = " + listOfAccs[i].Department.departmentName + ", Position = " + listOfAccs[i].Position.positionName + ", CreateDate = " + listOfAccs[i].createDate + ";<br>";
    }

    document.getElementById("acc").innerHTML = result;
}
// Method Câu 3: Tạo method in ra các số nguyên dương nhỏ hơn 10
function printPlusInt() {
    var txt = "";
    for (i = 1; i < 10; i++) {
        txt += i + ", ";
    }
    var n = txt.length;
    alert(txt.substring(0, n - 2));
}

// Program Câu 1: Check số nhập vào chẵn hay lẻ
function checkNumOddOrEven() {
    var txt = prompt("Mời nhập vào một số nguyên", 0);
    txt = Number(txt);
    if (txt !== null & Number.isInteger(txt)) {
        if (txt % 2 == 0) {
            alert(txt + " là số chẵn")
        } else {
            alert(txt + " là số lẻ")
        }
    } else {
        alert("Nhập số không chính xác");
    }
}
// Program Câu 2: Viết chương trình kiểm tra điểm
function checkScore() {
    var bl1 = false;
    do {
        var txt = prompt("Mời nhập điểm số (trong khoảng từ 1 đến 10):", "");
        txt = Number(txt);

        if (!Number.isInteger(Number(txt))) {
            alert("Điểm phải là một số nguyên, nhập lại");
            bl1 = false;
        } else if (Number(txt) < 1 || Number(txt) > 10) {
            alert("Điểm lớn hơn 0 và nhỏ hơn hoặc bằng 10, nhập lại");
            bl1 = false;
        } else {
            bl1 = true;
            if (Number(txt) == 9 || Number(txt) == 10) {
                alert("học sinh Giỏi");
            } else if (Number(txt) == 7 || Number(txt) == 8) {
                alert("học sinh Khá");
            } else if (Number(txt) == 5 || Number(txt) == 6) {
                alert("học sinh TB");
            } else {
                alert("học sinh Yếu");
            }
        }
    } while (bl1 == false);
}

// Program Câu 3: viết chương trình tính thời gian
function CalculateTime() {
    var bl1 = false;
    var t = 0;
    do {
        var txt = prompt("Mời nhập độ dài quãng đường (m):", "");
        txt = Number(txt);
        if (!Number.isInteger(Number(txt))) {
            alert("Điểm phải là một số nguyên, nhập lại");
            bl1 = false;
        } else {
            bl1 = true;
            if (txt >= 0 && txt <= 3000) {
                t = txt / 1;
            } else if (txt > 3000 && txt <= (3000 + 2000)) {
                t = 3000 / 1 + (txt - 3000) / (1 / 2);
            } else if (txt > (3000 + 2000) && txt <= (3000 + 2000 + 1000)) {
                t = 3000 / 1 + 2000 / (1 / 2) + (txt - (3000 + 2000)) / (1 / 3);
            } else if (txt > (3000 + 2000 + 1000)) {
                t = 3000 / 1 + 2000 / (1 / 2) + 1000 / (1 / 3) + (txt - (3000 + 2000 + 1000)) / (1 / 5);
            }
        }
    } while (bl1 == false);

    alert("Thời gian đi hết quãng đường là: " + txt + " giây (tương đương " + parseInt(txt / 60) + " phút " + txt % 60 + " giây)");
}

// Program Câu 4: Check điểm tín chỉ
function checkTinchi() {
    var score = "";
    var txt = prompt("Mời nhập điểm tín chỉ (A-Z):", "");
    if (txt == "A" || txt == "a") {
        score = "Điểm tín chỉ là: 4";
    } else if (txt == "B" || txt == "b") {
        score = "Điểm tín chỉ là: 3";
    } else if (txt == "C" || txt == "c") {
        score = "Điểm tín chỉ là: 2";
    } else if (txt == "D" || txt == "d") {
        score = "Điểm tín chỉ là: 1";
    } else {
        score = "Sinh viên này đã thôi học";
    }
    document.getElementById("Tinchi").innerHTML = score;
}

// Program Câu 5: Check số ngày trong tháng
function checkAmoutOfDayInMonth() {
    var month = Number(document.getElementById("month4").value);
    var year = Number(document.getElementById("year4").value);
    var result = 0;

    if (month !== null && year !== null) {
        var month31 = [1, 3, 5, 7, 8, 10, 12];
        var month30 = [4, 6, 9, 11];
        for (i = 0; i < month31.length; i++) {
            if (month == month31[i]) {
                result = 31;
            }
        }
        if (result == 0) {
            for (i = 0; i < month30.length; i++) {
                if (month == month30[i]) {
                    result = 30;
                }
            }
        }

        if (result == 0) {
            if (month == 2) {
                if ((year % 4 == 0 && year % 100 !== 0) || (year % 400 == 0)) {
                    result = 29;
                } else {
                    result = 28;
                }
            }
        }
        document.getElementById("songaytrongthang").innerHTML = result;
    }
}

// Program Câu 6: Đếm số các số chia hết cho 2
function check6() {
    var n = Number(document.getElementById("num6").value);
    var result = 0;
    if (n !== null && n !== 0) {
        if (n % 2 == 0) {
            result = (n - 2) / 2 + 1;
        } else {
            result = ((n - 1) - 2) / 2 + 1;
        }
        document.getElementById("p6").innerHTML = "Có " + result + " số chia hết cho 2 từ 1 đến " + n;
    }
}

// Program Câu 7: In các số trong ô input
function printNum() {
    var n = Number(document.getElementById("num7").value);
    var result = "";
    if (n !== null && n !== 0) {
        for (i = 1; i <= n; i++) {
            result += i + ", ";
        }
        var m = result.length;
        document.getElementById("text7").value = result.substring(0, m - 2);
    }
}