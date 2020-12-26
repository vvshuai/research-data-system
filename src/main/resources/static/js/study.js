function study_submit() {
    let options = $("#sel3 option:selected");　　　　//获取选中项
    let val = options.val();　　　　　　　　　　　　　　//获取选中项的值
    let myFormData = new FormData();

    if($('#file')[0].files[0] == null) {
        alert("请输入文件");
        return false;
    }

    switch (val) {
        case "0":
            myFormData.append("fileType", "开题报告");
            break;
        case "1":
            myFormData.append("fileType", "开题答辩PPT");
            break;
        case "2":
            myFormData.append("fileType", "中期报告");
            break;
        case "3":
            myFormData.append("fileType", "中期答辩PPT");
            break;
        case "4":
            myFormData.append("fileType", "毕业文档");
            break;
        case "5":
            myFormData.append("fileType", "毕业答辩PPT");
            break;
    }

    myFormData.append("file", $('#file')[0].files[0]);

    $.ajax({
        url : 'http://localhost:8080/study/upload',
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
}