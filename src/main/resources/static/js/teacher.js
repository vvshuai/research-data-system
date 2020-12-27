function students_submit() {
    let myFormData = new FormData();

    if($("#students-file")[0].files[0] == null) {
        alert("请上传文件");
        return false;
    }

    myFormData.append("file", $("#students-file")[0].files[0]);

    $.ajax({
        url : 'http://localhost:8080/user/uploadUsers',
        type : 'post',
        data : myFormData,
        success : function (data) {
            if(data.code == '200') {
                alert("上传成功");
            } else {
                alert("上传失败");
            }
        },
    });
}

function tag_submit() {
    let tagName = $("#tag-name").val();

    if(tagName == null) {
        alert("请填写标签");
        return false;
    }

    let data = {
        tagName : tagName
    }

    $.ajax({
        url : 'http://localhost:8080/user/addTag',
        type : 'post',
        data : data,
        success : function (data) {
            if(data.code == '200') {
                alert("上传成功");
            } else {
                alert("上传失败");
            }
        },
    });
}