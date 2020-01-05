/**
 * 
 */


function allcheck(){
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
/*		注意不要写错单词，form与from，ture与true；通过颜色改变可看出*/
		oCheck[i].checked=true;
	}
}

function delAllMem(){
	var allmid = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
		allmid.push(oCheck[i].value);
		flag = true;
		}
	}
	if(flag){
		if(confirm("您确定要删除这些记录吗？")){
			location.href="updateMem?f=delall&allmid="+allmid;
		}
	}else { 
		alert("您至少要选择一条记录，才能进行批量删除！");
	}
/*	可设alert(allmid);看看有没有取到ID */
}