function countWords() {
    var txt = document.getElementById("text1").value;
    if (txt !== "") {
        txt = txt.trim();
        var count = 0;
        var words = txt.split(" ");
        var n = 0;
        for (i = 0; i < words.length; i++) {
            if (words[i] == "") {
                n++;
            } else if (words[i].charAt(0) == " ") {
                n++;
            }

        }
        n = words.length - n;
        alert("Chuỗi có " + n + " từ");
    }
}

function noiChuoi() {
    var txt1 = document.getElementById("text1.1").value;
    var txt2 = document.getElementById("text1.2").value;
    var txt = txt1.concat(txt2);
    alert(txt);
}

function fixName() {
    var txt = document.getElementById("text3").value;
    if (txt !== "") {
        txt = txt.trim();
        words = txt.split(" ");
        var words1 = [];
        for (i = 0; i < words.length; i++) {
            if (words[i] == "") {

            } else if (txt[i].charAt(0) == " ") {

            } else {
                words1.push(words[i]);
            }
        }
        var result = "";
        for (i = 0; i < words1.length; i++) {
            words1[i] = words1[i].substring(0, 1).toUpperCase() + words1[i].substring(1, words1[i].length);
            result += words1[i] + " ";
        }
        result = result.trim();
        alert("Họ tên đã chuẩn hóa: " + result);
    }
}

function printName() {
    var txt = document.getElementById("text4").value;
    txt = txt.trim();
    var result = "";
    for (i = 0; i < txt.length; i++) {
        result += "Ký tự thứ " + i + " là: " + txt.charAt(i).toUpperCase() + " <br>";
    }
    document.getElementById("span4").innerHTML = result;
}