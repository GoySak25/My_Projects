var number1= Math.floor(Math.random()*6) +1;
var number2= Math.floor(Math.random()*6) +1;
var randomImage1="dice" +number1+".png";
var source1= "images/"+randomImage1;
var randomImage2= "dice" +number2+".png";
var source2= "images/"+randomImage2;
document.querySelectorAll("img")[0].setAttribute("src", source1)
document.querySelectorAll("img")[1].setAttribute("src", source2);
if(number1>number2){
	document.getElementsByTagName("H1")[0].innerHTML="🚩 Play 1 Wins!!";
}
else if(number1<number2){
	document.getElementsByTagName("H1")[0].innerHTML="Player 2 wins 🚩!!";
}
else{
	document.getElementsByTagName("H1")[0].innerHTML= "Draw!!";
}
