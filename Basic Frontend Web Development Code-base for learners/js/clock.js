function currentTime() {
  let date = new Date();
  let hh = date.getHours();
  let mm = date.getMinutes();
  let ss = date.getSeconds();
  // let ms = date.getMilliseconds();
  let session = "AM";

  if (hh == 0) {
    hh = 12;
  }
  if (hh > 12) {
    hh = hh - 12;
    session = "PM";
  }

  hh = hh < 10 ? "0" + hh : hh;
  mm = mm < 10 ? "0" + mm : mm;
  ss = ss < 10 ? "0" + ss : ss;
  // ms = ms < 10 ? "00" + ms : ms < 100 ? "0" + ms : ms;

  let time = hh + ":" + mm + ":" + ss + /*" " + ms + */ " " + session;

  document.getElementById("clock").innerText = time;
  let t = setTimeout(function () {
    currentTime();
  }, 1000);
}
function backToIndex() {
  window.location.href = "../index.html";
}
currentTime();
// function timeRemaining() {
//   return 20;
// }

function validInput() {
  debugger;
  var input = document.getElementById("input-minutes");
  let value = parseInt(input.value);
  if (value <= 0 && value > 10) return true;
  else return false;
}
function setTimer() {
  // debugger;
  const time = parseInt(document.getElementById("input-minutes").value);
  document.getElementById("timer-container").style.display = "none";
  document.getElementById("time-remaining").style.display = "block";
  document.getElementById("timer-for").innerHTML =
    "timer for : " + time + " minute(s)";
  let fractions = 1000;
  let fraction = time / fractions;
  // !setTimeout(dis, time * 60000);

  var interval = setInterval(() => {
    console.log("time has come");
    document.getElementById("input-time-remained").value =
      (fractions--).toString();
    if (fractions == -1) {
      clearInterval(interval);
      document.getElementById("time-reached").style.display = "block";
      return;
    }
  }, fraction * 60000);
}

function dis(i) {
  console.log("time has come");
  document.getElementById("input-time-remained").value = i.toString();
}
// document.getElementsByClassName("trial").innerHTML = "Time remaining";
// var trial = document.getElementsByClassName("trial");
// function trialFunction() {
//   setTimeout(() => {
//     trial.innerHTML = "trial has reached 2 seconds";
//   }, 2000);
//   setTimeout(() => {
//     trial.innerHTML = "trial has ended";
//   }, 4000);
// }
// trialFunction();
//setTimeout(dis, 10000);
