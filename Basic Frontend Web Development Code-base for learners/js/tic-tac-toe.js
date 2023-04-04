//Global variables
let gameArray = [null, null, null, null, null, null, null, null, null];
let moveCount = 0;
let previousMove = "";
let newMove = "";
let isVsComputer = false;

function clickedOn(num) {
  debugger;
  //   debugger;
  //If block is occupied return from here.
  if (gameArray[num] != null) return;

  //check if game isn't tied
  if (moveCount == 9) return;

  //assigning the correct X or O
  if (previousMove == "X") newMove = "O";
  else newMove = "X";

  //updating the gameArray for the new key entered
  gameArray[num] = newMove;

  //displaying the newMove character on screen
  let elementId = "block-" + num;
  let element = document.getElementById(elementId);
  element.innerHTML = newMove;

  moveCount++;
  if (moveCount > 4) isWin();
  previousMove = newMove;
  if (moveCount % 2 == 1 && isVsComputer == true) playComputer();
  else return;
}
function isWin() {
  let whoWon = null;

  if (gameArray[0] == gameArray[1] && gameArray[0] == gameArray[2] && gameArray[0] != null) whoWon = gameArray[0];
  else if (gameArray[3] == gameArray[4] && gameArray[3] == gameArray[5] && gameArray[3] != null) whoWon = gameArray[3];
  else if (gameArray[6] == gameArray[7] && gameArray[6] == gameArray[8] && gameArray[6] != null) whoWon = gameArray[6];
  else if (gameArray[0] == gameArray[3] && gameArray[0] == gameArray[6] && gameArray[0] != null) whoWon = gameArray[0];
  else if (gameArray[1] == gameArray[4] && gameArray[1] == gameArray[7] && gameArray[1] != null) whoWon = gameArray[1];
  else if (gameArray[2] == gameArray[5] && gameArray[2] == gameArray[8] && gameArray[2] != null) whoWon = gameArray[2];
  else if (gameArray[0] == gameArray[4] && gameArray[0] == gameArray[8] && gameArray[0] != null) whoWon = gameArray[0];
  else if (gameArray[2] == gameArray[4] && gameArray[2] == gameArray[6] && gameArray[2] != null) whoWon = gameArray[2];

  // !My first Method was like this
  // if (gameArray[0] == "X" && gameArray[1] == "X" && gameArray[2] == "X") whoWon = "X";
  // else if (gameArray[3] == "X" && gameArray[4] == "X" && gameArray[5] == "X") whoWon = "X";
  // else if (gameArray[6] == "X" && gameArray[7] == "X" && gameArray[8] == "X") whoWon = "X";
  // else if (gameArray[0] == "X" && gameArray[3] == "X" && gameArray[6] == "X") whoWon = "X";
  // else if (gameArray[1] == "X" && gameArray[4] == "X" && gameArray[7] == "X") whoWon = "X";
  // else if (gameArray[2] == "X" && gameArray[5] == "X" && gameArray[8] == "X") whoWon = "X";
  // else if (gameArray[0] == "X" && gameArray[4] == "X" && gameArray[8] == "X") whoWon = "X";
  // else if (gameArray[2] == "X" && gameArray[4] == "X" && gameArray[6] == "X") whoWon = "X";
  // else if (gameArray[0] == "O" && gameArray[1] == "O" && gameArray[2] == "O") whoWon = "O";
  // else if (gameArray[3] == "O" && gameArray[4] == "O" && gameArray[5] == "O") whoWon = "O";
  // else if (gameArray[6] == "O" && gameArray[7] == "O" && gameArray[8] == "O") whoWon = "O";
  // else if (gameArray[0] == "O" && gameArray[3] == "O" && gameArray[6] == "O") whoWon = "O";
  // else if (gameArray[1] == "O" && gameArray[4] == "O" && gameArray[7] == "O") whoWon = "O";
  // else if (gameArray[2] == "O" && gameArray[5] == "O" && gameArray[8] == "O") whoWon = "O";
  // else if (gameArray[0] == "O" && gameArray[4] == "O" && gameArray[8] == "O") whoWon = "O";
  // else if (gameArray[2] == "O" && gameArray[4] == "O" && gameArray[6] == "O") whoWon = "O";

  //if game is draw or incomplete
  if (whoWon == null && moveCount == 9) {
    document.getElementById("before-game-results").style.display = "none";
    document.getElementById("after-game-results").style.display = "flex";
    document.getElementById("who-won").innerText = "TIED";
  }

  //if someone has won the game
  else if (whoWon == "X") {
    document.getElementById("before-game-results").style.display = "none";
    document.getElementById("after-game-results").style.display = "flex";
    if (isVsComputer == true) document.getElementById("who-won").innerText = "YOU-WON";
    else document.getElementById("who-won").innerText = "X-WON";
    //disabling the further inputs by user we pretend like the game is tied
    moveCount = 9;
  } else if (whoWon == "O") {
    document.getElementById("before-game-results").style.display = "none";
    document.getElementById("after-game-results").style.display = "flex";
    if (isVsComputer == true) document.getElementById("who-won").innerText = "YOU-LOSE";
    else document.getElementById("who-won").innerText = "O-WON";
    moveCount = 9;
  }
}
function reset() {
  gameArray = [null, null, null, null, null, null, null, null, null];
  moveCount = 0;
  previousMove = "";
  newMove = "";
  document.getElementById("block-0").innerHTML = "";
  document.getElementById("block-1").innerHTML = "";
  document.getElementById("block-2").innerHTML = "";
  document.getElementById("block-3").innerHTML = "";
  document.getElementById("block-4").innerHTML = "";
  document.getElementById("block-5").innerHTML = "";
  document.getElementById("block-6").innerHTML = "";
  document.getElementById("block-7").innerHTML = "";
  document.getElementById("block-8").innerHTML = "";
  document.getElementById("before-game-results").style.display = "block";
  document.getElementById("after-game-results").style.display = "none";
}
function vsPlayer() {
  if (isVsComputer == false) return;
  let yesReset = false;
  if (moveCount == 0 || moveCount == 9) yesReset = true;
  else if (moveCount > 0 && moveCount < 9) {
    yesReset = confirm("Do you want to reset the current game?");
  }
  if (yesReset == true) {
    reset();
    isVsComputer = false;
    document.getElementById("vsplayer").style.backgroundColor = "#2b6ea4";
    document.getElementById("vscomputer").style.backgroundColor = "#271612";
    document.getElementById("vsplayer").style.fontSize = "1.2em";
    document.getElementById("vscomputer").style.fontSize = "1em";
  }
}
function vsComputer() {
  if (isVsComputer == true) return;
  let yesReset = false;
  //if game was played before changing the VS mode then an user is
  //asked do you really want to reset.
  if (moveCount == 0 || moveCount == 9) yesReset = true;
  else if (moveCount > 0 && moveCount < 9) {
    yesReset = confirm("Do you want to reset the current game?");
  }
  //if users confirms the reset request then the game resets and
  //color switches appropriately
  if (yesReset == true) {
    reset();
    isVsComputer = true;
    document.getElementById("vsplayer").style.backgroundColor = "#271612";
    document.getElementById("vscomputer").style.backgroundColor = "#2b6ea4";
    document.getElementById("vscomputer").style.fontSize = "1.2em";
    document.getElementById("vsplayer").style.fontSize = "1em";
  }
}
function playComputer() {
  let canWin = -1;
  let canLose = -1;
  let randomLocation = -1;

  //!check for win
  //computer can only win when it is in its 5th or 7th turn.
  if (moveCount == 5 || moveCount == 7) {
    canWin = checkForWin();
    if (canWin != -1) {
      clickedOn(canWin);
      return;
    }
  }

  //!check for lose
  if (moveCount >= 3) {
    canLose = checkForLose();
    if (canLose != -1) {
      clickedOn(canLose);
      return;
    }
  }

  // !Placing the O on the center of box if the user places the X on any corner
  if (moveCount == 1 && (gameArray[0] == "X" || gameArray[2] == "X" || gameArray[6] == "X" || gameArray[8] == "X")) {
    clickedOn(4);
    return;
  }

  //!play a random shot
  randomLocation = playRandom();
  clickedOn(randomLocation);
}

function checkForWin() {
  //0
  if (gameArray[0] == "O") {
    if (gameArray[1] == "O" && gameArray[2] == null) return 2;
    else if (gameArray[2] == "O" && gameArray[1] == null) return 1;
    else if (gameArray[3] == "O" && gameArray[6] == null) return 6;
    else if (gameArray[4] == "O" && gameArray[8] == null) return 8;
    else if (gameArray[6] == "O" && gameArray[3] == null) return 3;
    else if (gameArray[8] == "O" && gameArray[4] == null) return 4;
  }
  //1
  if (gameArray[1] == "O") {
    if (gameArray[2] == "O" && gameArray[0] == null) return 0;
    else if (gameArray[4] == "O" && gameArray[7] == null) return 7;
    else if (gameArray[7] == "O" && gameArray[4] == null) return 4;
  }
  //2
  if (gameArray[2] == "O") {
    if (gameArray[4] == "O" && gameArray[6] == null) return 6;
    else if (gameArray[5] == "O" && gameArray[8] == null) return 8;
    else if (gameArray[6] == "O" && gameArray[4] == null) return 4;
    else if (gameArray[8] == "O" && gameArray[5] == null) return 5;
  }
  //3
  if (gameArray[3] == "O") {
    if (gameArray[4] == "O" && gameArray[5] == null) return 5;
    else if (gameArray[5] == "O" && gameArray[4] == null) return 4;
    else if (gameArray[6] == "O" && gameArray[0] == null) return 0;
  }
  //4
  if (gameArray[4] == "O") {
    if (gameArray[5] == "O" && gameArray[3] == null) return 3;
    else if (gameArray[6] == "O" && gameArray[2] == null) return 2;
    else if (gameArray[7] == "O" && gameArray[1] == null) return 1;
    else if (gameArray[8] == "O" && gameArray[0] == null) return 0;
  }
  //5
  if (gameArray[5] == "O") {
    if (gameArray[8] == "O" && gameArray[2] == null) return 2;
  }
  //6
  if (gameArray[6] == "O") {
    if (gameArray[7] == "O" && gameArray[8] == null) return 8;
    else if (gameArray[8] == "O" && gameArray[7] == null) return 7;
  }
  //7
  if (gameArray[7] == "O") {
    if (gameArray[8] == "O" && gameArray[6] == null) return 6;
  }
  return -1;
}
function checkForLose() {
  //0
  if (gameArray[0] == "X") {
    if (gameArray[1] == "X" && gameArray[2] == null) return 2;
    else if (gameArray[2] == "X" && gameArray[1] == null) return 1;
    else if (gameArray[3] == "X" && gameArray[6] == null) return 6;
    else if (gameArray[4] == "X" && gameArray[8] == null) return 8;
    else if (gameArray[6] == "X" && gameArray[3] == null) return 3;
    else if (gameArray[8] == "X" && gameArray[4] == null) return 4;
  }
  //1
  if (gameArray[1] == "X") {
    if (gameArray[2] == "X" && gameArray[0] == null) return 0;
    else if (gameArray[4] == "X" && gameArray[7] == null) return 7;
    else if (gameArray[7] == "X" && gameArray[4] == null) return 4;
  }
  //2
  if (gameArray[2] == "X") {
    if (gameArray[4] == "X" && gameArray[6] == null) return 6;
    else if (gameArray[5] == "X" && gameArray[8] == null) return 8;
    else if (gameArray[6] == "X" && gameArray[4] == null) return 4;
    else if (gameArray[8] == "X" && gameArray[5] == null) return 5;
  }
  //3
  if (gameArray[3] == "X") {
    if (gameArray[4] == "X" && gameArray[5] == null) return 5;
    else if (gameArray[5] == "X" && gameArray[4] == null) return 4;
    else if (gameArray[6] == "X" && gameArray[0] == null) return 0;
  }
  //4
  if (gameArray[4] == "X") {
    if (gameArray[5] == "X" && gameArray[3] == null) return 3;
    else if (gameArray[6] == "X" && gameArray[2] == null) return 2;
    else if (gameArray[7] == "X" && gameArray[1] == null) return 1;
    else if (gameArray[8] == "X" && gameArray[0] == null) return 0;
  }
  //5
  if (gameArray[5] == "X") {
    if (gameArray[8] == "X" && gameArray[2] == null) return 2;
  }
  //6
  if (gameArray[6] == "X") {
    if (gameArray[7] == "X" && gameArray[8] == null) return 8;
    else if (gameArray[8] == "X" && gameArray[7] == null) return 7;
  }
  //7
  if (gameArray[7] == "X") {
    if (gameArray[8] == "X" && gameArray[6] == null) return 6;
  }
  return -1;
}
function playRandom() {
  let randomArray = [];
  let index = 0;

  for (var i = 0; i < gameArray.length; i++) {
    if (gameArray[i] == null) {
      randomArray[index] = i;
      index++;
    }
  }
  let randomIndex = Math.floor(Math.random() * randomArray.length);
  return randomArray[randomIndex];
}
