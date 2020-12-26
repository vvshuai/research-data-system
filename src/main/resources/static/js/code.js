//动态加载标签checkbox
$(function GetCompareYearByStationName() {
    $.ajax({
        type: "GET",  //默认是GET
        url: 'http://localhost:8080/code/queryTags',
        async: false,  //异步
        cache: false, //不加载缓存
        success: function (res) {
            let data = res.data;
            let str = '';
            data.forEach((item)=>{
                str += "<label class=\"btn btn-default\"><input type='checkbox' name='tags' value='" + item.id+ "' /> " + item.tagName + "</label>";
            });
            $("#tagGroup").html(str);
        }
    });
});

function code_submit() {
    let code_name = $('#code_name').val();
    let code_description = $('#code_description').val();
    let ids = document.getElementsByName('tags');
    let tags = [];
    for(let i = 0;i < ids.length; i++) {
        if(ids[i].checked) {
            tags.push(ids[i].value);
        }
    }

    if(tags.length == 0) {
        alert("请选择标签");
        return false;
    }

    if($('#code-file')[0].files[0] == null) {
        alert("请输入文件");
        return false;
    }

    if($('#readme-file')[0].files[0] == null) {
        alert("请输入文件");
        return false;
    }

    let myFormData = new FormData();
    myFormData.append("codeName", code_name);
    myFormData.append("codeDescription", code_description);
    for(var i = 0;i < tags.length; i++) {
        myFormData.append("tags", tags[i]);
    }
    myFormData.append("codeFile", $('#code-file')[0].files[0]);
    myFormData.append("readmeFile", $('#readme-file')[0].files[0]);


    $.ajax({
        url: 'http://localhost:8080/code/upload',
        type: 'post',
        data: myFormData,
        contentType: false,
        processData: false,
        cache: false,
        success : function (data) {
            if (data.code == '200') {
                alert("上传成功");
                $('#table').bootstrapTable('refresh');
            } else {
                alert("上传失败");
            }
        }
    });
}

