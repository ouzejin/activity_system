/**
 * 
 */


//ȫѡ
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
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			location.href="updateBudget?f=delall&allmid="+allmid+"&allwid="+allwid;
		}
	}else { 
		alert("������Ҫѡ��һ����¼���ܽ�������ɾ����");
	}

}