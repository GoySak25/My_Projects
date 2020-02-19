var gamePattern=[];
var userClickedPattern=[];
var buttonColours=["red", "blue", "green", "yellow"];
var level;

function nextSequence(){
    level++;
    $("#level-title").html("Level "+level);
    var randomNumber= Math.floor(Math.random()*4);
    var randomChosenColour= buttonColours[randomNumber];
    gamePattern.push(randomChosenColour);
    var selectedElement= "."+randomChosenColour;
    var selectedElement1= randomChosenColour+"Btn";
    playSound(selectedElement1);
    $(selectedElement).fadeToggle(50).fadeToggle(50).fadeToggle(50).fadeToggle(50);
}

$(".btn").click(function(){
    var userChosenButton=this.id;
    animatePress(userChosenButton);
    userClickedPattern.push(userChosenButton);
    var selector= userChosenButton+"Btn";
    playSound(selector);
    if(gamePattern.length==userClickedPattern.length){
        var i;
        var isRight=true;
        for(i=0; i<gamePattern.length; i++){
            if(gamePattern[i]==userClickedPattern[i]){
                continue;
            }
            else{
                isRight=false;
                gameOver();
                break;
            }
        }
        userClickedPattern=[];
        if(isRight){           
            nextSequence();
        }       
    }
});

function gameOver(){
    document.querySelector("body").classList.add("game-over");
    setTimeout(function(){
        $("body").removeClass("game-over")
    }, 200);
    $("h1").html("Game Over, Press Any Key Restart");
    startOver();
}

function playSound(name){
    var x= document.getElementById(name);
    x.play();
}

function animatePress(currentColour){
    var selectedValue= "."+currentColour;
    $(selectedValue).addClass("pressed");
    setTimeout(RemoveClass, 100);
    function RemoveClass(){
        $(selectedValue).removeClass("pressed");
    }
}

startOver();
function startOver(){
    gamePattern=[];
    var started=0;
    $(document).keypress(function(){    
        if(started==0){         
            level=0;
            started=1;
            nextSequence();
        }
    });
}

    
