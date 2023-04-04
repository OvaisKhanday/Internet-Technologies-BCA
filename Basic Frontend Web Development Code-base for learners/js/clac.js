let digits_array = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"];
let operations_array = ["+", "-", "*", "/", "%"];
let dot_key = ".";
let clear_key = "C";
let equal_key = "=";
let dot_exists_flag = false; //there must be only one dot in each number a user enters.
let current_operator = null;
let previous_key = clear_key;

let string_operand = "";
let operand1 = null;
let operand2 = null;
let new_key = "";
let ele_operand1 = document.getElementById("operand1-display");
let ele_operand2 = document.getElementById("operand2-display");
let ele_operator = document.getElementById("operator-display");

function clickedOn(input_char) {
  // debugger;
  new_key = input_char;
  //!clear
  if (new_key == clear_key) {
    clear();
    previous_key = "clear";
  }
  //!digit
  else if (digits_array.includes(new_key)) {
    digit();
    previous_key = "digit";
    if (operand1 == null) ele_operand1.innerHTML = string_operand;
    else ele_operand2.innerHTML = string_operand;
  }
  //!operation
  else if (operations_array.includes(new_key)) {
    operator();
    previous_key = "operator";
  }
  //!dot
  else if (new_key == dot_key) {
    if (dot_exists_flag == false) {
      //adding a trailing 0 if dot is the first input by user.
      if (string_operand == "") string_operand += "0.";
      else string_operand += new_key;
      dot_exists_flag = true;
      if (operand1 == null) ele_operand1.innerHTML = string_operand;
      else ele_operand2.innerHTML = string_operand;
    }
    let temp = string_operand;
    if (operand1 != null && current_operator == null) {
      clear();
      string_operand = temp;
      ele_operand1.innerHTML = string_operand;
    }
    previous_key = "digit";
  }
  //!equals
  else if (new_key == equal_key) {
    equals();
    previous_key = "equals";
  } else if (new_key == "+/-") {
    plusMinus();
  } else if (new_key == "backspace") {
    backspace();
  }
}

function digit() {
  if (previous_key == "equals" && operand1 != null && string_operand != "") clear();
  string_operand += new_key;
  if (
    string_operand.length == 2 &&
    string_operand.charAt(1) != "." &&
    string_operand.charAt(0) == "0"
  ) {
    let temp = string_operand.charAt(1);
    string_operand = "";
    string_operand = temp;
  }
}
function clear() {
  string_operand = "";
  operand1 = operand2 = null;
  dot_exists_flag = false;
  previous_key = clear_key;
  current_operator = null;
  ele_operand1.innerHTML = operand1;
  ele_operand2.innerHTML = string_operand;
  ele_operator.innerHTML = current_operator;
}
function operator() {
  if (previous_key == "equals" && current_operator == null && operand1 == null) {
    if (string_operand != "") {
      operand1 = parseFloat(string_operand);
      string_operand = "";
      current_operator = new_key;
      dot_exists_flag = false;
    } else if (string_operand == "") {
      //not accepting operator after pseudo =
      current_operator = null;
    }
  } else if (
    previous_key == "equals" &&
    current_operator == null &&
    operand1 != null &&
    string_operand == ""
  ) {
    current_operator = new_key;
  } else if (previous_key == "digit" && string_operand != "") {
    if (current_operator == null) {
      operand1 = parseFloat(string_operand);
      string_operand = "";
      dot_exists_flag = false;
      current_operator = new_key;
    } else if (current_operator != null) {
      // string_operand = "";
      // dot_exists_flag = false;
      operations();
      current_operator = new_key;
    }
  }
  // } else if (previous_key == "digit" && string_operand == "") {
  //   current_operator = new_key;}
  else if (previous_key == "operator" && operand1 != null) current_operator = new_key;
  // else current_operator = new_key;
  ele_operator.innerHTML = current_operator;
}

function equals() {
  if (previous_key == "operator") {
    current_operator = null;
    ele_operator.innerHTML = current_operator;
  }
  if (string_operand != "" && operand1 != null) operations();
}
function operations() {
  let results = null;
  let op = current_operator;
  // let divide_by_zero_flag = false;
  operand2 = parseFloat(string_operand);
  if (op == "+") results = operand1 + operand2;
  else if (op == "-") results = operand1 - operand2;
  else if (op == "*") results = operand1 * operand2;
  else if (op == "/") {
    if (operand2 == 0) {
      results = 0;
      alert("Divide by zero");
      // divide_by_zero_flag = true;
      console.log("divide by zero no allowed");
    } else results = operand1 / operand2;
  } else if (op == "%") {
    results = (operand1 / operand2) * 100;
  }
  operand1 = results;
  operand2 = null;
  current_operator = null;
  string_operand = "";
  dot_exists_flag = false;
  ele_operand1.innerHTML = results;
  ele_operand2.innerHTML = operand2;
  ele_operator.innerHTML = current_operator;
  console.log("results are: " + results);
}

function plusMinus() {
  if (string_operand.charAt(0) == "-") {
    string_operand = string_operand.substr(1);
  } else if (string_operand.charAt(0) != "-") {
    let temp = "-" + string_operand;
    string_operand = temp;
  }
  if (operand1 == null) ele_operand1.innerHTML = string_operand;
  else ele_operand2.innerHTML = string_operand;
}
function backspace() {
  string_operand = string_operand.substr(0, string_operand.length - 1);
  if (operand1 == null) ele_operand1.innerHTML = string_operand;
  else ele_operand2.innerHTML = string_operand;
}
// function operationDetected() {
//   // current_operation = new_key;

//   if (string_operand == "" && operand1 != null) {
//     current_operation = new_key;
//   } else if (string_operand != "" && operand1 == null) {
//     operand1 = parseFloat(string_operand);
//     string_operand = "";
//     current_operation = new_key;
//   } else if (string_operand != "" && operand1 != null) {
//     operand2 = parseFloat(string_operand);
//     string_operand = "";
//     current_operation = new_key;
//   }
//   dot_exists_flag = false;

//   // if (string_operand == "") {
//   //   if (operand1 == null) operationNotPossible("operand not exists");
//   //   else if (operand1 != null && previous_key_was_operation_flag) {
//   //     current_operation = new_key;
//   //   }
//   //   return;
//   // } else if (operand1 != null) {
//   //   //if operand 1 had some value in it and the operation key was pressed.
//   //   operand2 = parseFloat(string_operand);
//   //   string_operand = "";
//   //   operation(current_operation);
//   //   dot_exists_flag = false;
//   //   previous_key_was_operation_flag = true;
//   // } else {
//   //   operand1 = parseFloat(string_operand);
//   //   string_operand = "";
//   //   dot_exists_flag = false;
//   //   previous_key_was_operation_flag = true;
//   //   // current_operation = new_key;
//   //   console.log("number: " + operand1);
//   // }
// }
// function equalKeyDetected() {
//   if (operand1 != null && string_operand != "") {
//     operand2 = parseFloat(string_operand);
//     string_operand = "";
//     operation(current_operation);
//   }
// }
// function operation(op) {
//   let results = null;
//   if (op == "+") results = operand1 + operand2;
//   else if (op == "-") results = operand1 - operand2;
//   else if (op == "*") results = operand1 * operand2;
//   else if (op == "/") {
//     if (operand2 == 0) {
//       console.log("divide by zero no allowed");
//     } else results = operand1 / operand2;
//   } else if (op == "%") {
//     results = (operand1 / operand2) * 100;
//   }
//   dot_exists_flag = false;
//   operand1 = results;
//   operand2 = null;
//   element.innerHTML = results;

//   console.log("results are: " + results);
// }
// function operationNotPossible(msg) {
//   console.log(msg);
//   previous_key_was_operation_flag = false;
//   // string_operand = "";
//   // operand1 = operand2 = null;
// }
