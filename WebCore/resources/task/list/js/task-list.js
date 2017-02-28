function finishNow(id){
    $.post("finishTask", {'id':id}, function() {
        $("#task_finish_"+id).html("Finished");
        var date = new Date();
        var day = date.getDate();
        var month = date.getMonth() + 1;
        var year = date.getFullYear();
        var strDate = year + '-' + month + '-' + day;
        $("#task_finishedDate_"+id).html(strDate);
    });
}
