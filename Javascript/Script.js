let result=document.getElementById("input");
function display(num){
    result.value=result.value+num;

}
function calculate(){
    try{
        result.value=eval(result.value);
    }catch(err){
         alert("invalid");
    }
}
function clean(){
        result.value="";
}
function del(){
   result.value=result.value.slice(0,-1);
}
