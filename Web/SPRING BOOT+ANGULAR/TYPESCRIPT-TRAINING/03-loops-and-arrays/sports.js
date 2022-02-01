var sportOne = ["golf", "cricket", "tennis", "swimming"];
//simplified for loop
for (var _i = 0, sportOne_1 = sportOne; _i < sportOne_1.length; _i++) {
    var tempSport = sportOne_1[_i];
    if (tempSport == "cricket") {
        console.log(tempSport + "<< my favorite");
    }
    else {
        console.log(tempSport);
    }
}
