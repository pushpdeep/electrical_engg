
var text2display = "";
var ans = new Array(3);
	ans[0] = "1. first ans\n";
	ans[1] = "2. second ans\n";
	ans[2] = "3. third ans\n";
	ans[3] = "4. fourth ans\n";
	ans[4] = "5. fifth ans\n";
	ans[5] = "6. fifth ans\n";
	
var que = new Array(3);
	que[0] = "q1";
	que[1] = "q2";
	que[2] = "q3";
	que[3] = "q4";
	que[4] = "q5";
	que[5] = "q6";


function checkQs(s)
{
	var qs = document.getElementsByName(s);
	var noofradio = qs.length;
	
	for(var i=0; i < noofradio; i++)
	{
	if(qs[i].checked)
	{
			if(qs[i].value=="correct")
			text2display = text2display+(que.indexOf(s)+1)+". correct answer\n"
			else text2display = text2display+ ans[que.indexOf(s)];
			break;
			
	}
	}
}


function checkAllQs()
{
	text2display = "";
	for(var i=0; i < que.length; i++)
	{
	checkQs(que[i]);
	}
	quiz.answerbox.value = text2display;
}

function reset() {
	text2display = "";
	    location.reload();
}
