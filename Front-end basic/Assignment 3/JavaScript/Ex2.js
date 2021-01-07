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
    if (x === 1) {
        this.positionName = "Dev";
    } else if (x === 2) {
        this.positionName = "Test";
    } else if (x === 3) {
        this.positionName = "Scrum Master";
    } else if (x === 4) {
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
    if (departmentID > listOfDepts.length + 1) {
        this.Department = "Phòng chờ";
    } else {
        this.Department = listOfDepts[departmentID + 1];
    }
    if (positionID > listOfPositions.length + 1) {
        this.Position = "Chờ việc";
    } else {
        this.Position = listOfPositions[positionID + 1];
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

// Tạo hàm kiểm tra department của account
function checkDept(accountID) {
    var bl = false;
    listOfAccs.forEach(acc => {
        if (acc.accountID == accountID) {
            bl = true;
            if (acc.Department !== null) {
                document.write("Phòng ban của account với ID = " + accountID + " là: " + acc.Department.departmentName);
            } else {
                document.write("Nhân viên này chưa có phòng ban");
            }
        }
    });
    if (bl == false) {
        document.write("Account không tồn tại");
    }
}

// Tạo hàm kiểm tra group của account
function checkGr(accountID) {

}