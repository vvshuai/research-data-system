function other_submit() {
    var otherFileName = $("#other_file_name").val();
    var otherFileText = $("#other_file_text").val();

    if(otherFileName == null) {
        alert("请填写文档名");
        return false;
    }

    if(otherFileText == null) {
        alert("请填写文档简介");
        return false;
    }
    if($('#other-file')[0].files[0] == null) {
        alert("请输入文件");
        return false;
    }

    var myFormData = new FormData();
    myFormData.append("otherFileName", otherFileName);
    myFormData.append("otherFileText", otherFileText);

    myFormData.append("otherFile", $('#other-file')[0].files[0]);
    $.ajax({
        url : 'http://localhost:8080/other/upload',
        type : 'post',
        data : myFormData,
        contentType: false,
        processData: false,
        cache : false,
        success : function (data) {
            if(data.code == '200') {
                alert("上传成功");
                $('#table').bootstrapTable('refresh');
            } else {
                alert("上传失败");
            }
        },
        error : function (data) {
            alert('文件过大');
        }
    });
    return false;
}