function paper_submit(){
    let paper_name = $('#paper-name').val();
    let paper_year = $('#paper-year').val();
    let paper_meeting = $('#paper-meeting').val();
    let paper_writer = $('#paper-writer').val();

    if(paper_meeting == null || paper_name == null || paper_writer == null || paper_year == null) {
        alert('请填写参数');
        return false;
    }

    if($('#paper-file')[0].files[0] == null) {
        alert("请输入文件");
        return false;
    }
    if($('#ppt').length > 0) {
        if($('#ppt-file')[0].files[0] == null) {
            alert('请输入ppt文件');
            return false;
        }
    }

    let myFormData = new FormData();
    myFormData.append('paperName', paper_name);
    myFormData.append('paperYear', paper_year);
    myFormData.append('paperMeeting', paper_meeting);
    myFormData.append('paperWriter', paper_writer);
    myFormData.append('paperFile', $('#paper-file')[0].files[0]);
    if($('#ppt').length > 0) {
        myFormData.append('pptFile', $('#ppt-file')[0].files[0]);
    }


    $.ajax({
        url : 'http://localhost:8080/paper/upload',
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