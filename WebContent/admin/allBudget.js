/**
 * 
 */


//全选
function allcheck(){
	var oCheck = document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked=true;
	}
}


function delAllBudget(){
	var allmid = new Array();
	var allwid = new Array();
	var flag = false;
	var oCheck = document.getElementsByName('check');
	var mid = document.getElementsByName('mid');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			allwid.push(oCheck[i].value);
			allmid.push(mid[i].value);
			flag = true;
		}
	}
	if(flag){
		if(confirm("您确定要删除这些记录吗？")){
			location.href="updateBudget?f=delall&allmid="+allmid+"&allwid="+allwid;
		}
	}else { 
		alert("您至少要选择一条记录才能进行批量删除！");
	}

}