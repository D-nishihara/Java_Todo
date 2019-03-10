/**
 *
 */

//function deleterowget(){
//	var test = document.getElementById('tableid');
//
//	var test2 = this.closest('tr');
//
//	console.log(test2);
//}

$("[id=delete]").click(function(){
	var test = document.getElementById('tableid');
	console.log(test.rows.length);
	var index = $("[id=delete]").index(this);
	console.log(index);
	for(i=0; i<test.rows.length; i++){
		console.log(test.rows[i].rowIndex);
		if(test.rows[i].rowIndex == index+1){
			var val = test.rows[i].innerHTML;
			console.log(val);
		}
		else{
			console.log("false");
		}
	}

})