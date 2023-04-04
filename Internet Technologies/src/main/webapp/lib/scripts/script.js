const maxRollNoLength = 18; // long is used in java to avoid conflict.
const maxNameLength = 25;
const maxAddressLength = 45;
const maxPhoneNoLength = 10;

// These are the validators used on the front end.

function validateUpdateForm() {
  const existingRollNo = document.forms.updateForm.existingRollNo.value;
  const rollNo = document.forms.updateForm.rollNo.value;
  const name = document.forms.updateForm.name.value.trim();
  const address = document.forms.updateForm.address.value.trim();
  const phoneNo = document.forms.updateForm.phoneNo.value;

  if (!validRollNo(existingRollNo)) return false;
  if (rollNo == "" && name == "" && address == "" && phoneNo == "") {
    alert("at least one field should be provided to update.");
    return false;
  }
  let isRollNoValid = true;
  let isNameValid = true;
  let isAddressValid = true;
  let isPhoneNoValid = true;

  rollNo != "" ? (isRollNoValid = validRollNo(rollNo)) : true;
  name != "" ? (isNameValid = validName(name)) : true;
  address != "" ? (isAddressValid = validAddress(address)) : true;
  phoneNo != "" ? (isPhoneNoValid = validPhoneNo(phoneNo)) : true;

  if (isRollNoValid && isNameValid && isAddressValid && isPhoneNoValid) return true;
  return false;
}

function validateSearchForm() {
  const rollNo = document.forms.searchForm.rollNo.value;
  const name = document.forms.searchForm.name.value.trim();
  const address = document.forms.searchForm.address.value.trim();
  const phoneNo = document.forms.searchForm.phoneNo.value;
  if (rollNo == "" && name == "" && address == "" && phoneNo == "") {
    alert("at least one field should be provided");
    return false;
  }
  let isRollNoValid = true;
  let isNameValid = true;
  let isAddressValid = true;
  let isPhoneNoValid = true;

  rollNo != "" ? (isRollNoValid = validRollNo(rollNo)) : true;
  name != "" ? (isNameValid = validName(name)) : true;
  address != "" ? (isAddressValid = validAddress(address)) : true;
  phoneNo != "" ? (isPhoneNoValid = validPhoneNo(phoneNo)) : true;

  if (isRollNoValid && isNameValid && isAddressValid && isPhoneNoValid) return true;
  return false;
}

function validateDeleteForm() {
  const rollNo = document.forms.deleteForm.rollNo.value;
  const name = document.forms.deleteForm.name.value.trim();
  const address = document.forms.deleteForm.address.value.trim();
  const phoneNo = document.forms.deleteForm.phoneNo.value;
  if (rollNo == "" && name == "" && address == "" && phoneNo == "") {
    alert("at least one field should be provided");
    return false;
  }

  let isRollNoValid = true;
  let isNameValid = true;
  let isAddressValid = true;
  let isPhoneNoValid = true;

  rollNo != "" ? (isRollNoValid = validRollNo(rollNo)) : true;
  name != "" ? (isNameValid = validName(name)) : true;
  address != "" ? (isAddressValid = validAddress(address)) : true;
  phoneNo != "" ? (isPhoneNoValid = validPhoneNo(phoneNo)) : true;

  if (isRollNoValid && isNameValid && isAddressValid && isPhoneNoValid) return true;
  return false;
}

function validateAddForm() {
  const rollNo = document.forms.addForm.rollNo.value;
  const name = document.forms.addForm.name.value.trim();
  const address = document.forms.addForm.address.value.trim();
  const phoneNo = document.forms.addForm.phoneNo.value;

  if (validRollNo(rollNo) && validName(name) && validPhoneNo(phoneNo) && validPhoneNo(phoneNo)) return true;
  return false;
}

function validRollNo(rollNo) {
  if (rollNo.length < 1 || rollNo.length > maxRollNoLength) {
    alert("Please enter a proper roll no. max length is 18.");
    return false;
  }
  return true;
}

function validName(name) {
  if (name.length < 1 || name.length > maxNameLength) {
    alert("Please enter a proper name");
    return false;
  }
  return true;
}

function validAddress(address) {
  if (address.length < 1 || address.length > maxAddressLength) {
    alert("Please enter a proper address");
    return false;
  }
  return true;
}

function validPhoneNo(phoneNo) {
  if (phoneNo.charAt(0) == "-") {
    alert("Please enter a valid phone no");
    return false;
  } else if (phoneNo.length == maxPhoneNoLength) return true;
  alert("Please enter a 10 digit phone no");
  return false;
}
