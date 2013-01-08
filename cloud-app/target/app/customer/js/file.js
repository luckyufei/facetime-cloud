$(function(){
 var upload = $('#swfupload-ctrl').swfupload({
  upload_url: "http://localhost:8080/app/file/upload?realSessionId="+window["sessionId"],
  post_params: { "JSESSIONID" : window["sessionId"] },
  file_post_name: "file" , // 对应controller中的参数
  file_size_limit : "100 MB",
  file_types : "*.*",
  file_types_description : "All Files",
  file_upload_limit : "0",
  flash_url : "../upload/swfupload.swf",
  button_image_url : '../upload/img/btn_sprit_min.gif',
  button_width : 88,
  button_height : 18,
  button_placeholder : $('#btn-upload')[0],
  button_text: '<span class="theFont">添加新文件</span>',
  button_text_style: ".theFont { font-size: 13px;background-color: yellow;}",
  //button_text_left_padding: 12,
  //button_text_top_padding: 3,
  debug: false,
  custom_settings : {something : "here"}
 })
  .bind('swfuploadLoaded', function(event){
    // $('#log').append('<li>Loaded</li>');
  })
  .bind('fileQueued', function(event, file){
   // $('#log').append('<li>File queued - '+file.name+'</li>');
      var tr = "<tr><td></td><td></td><td></td><td><span></span></td></tr>";       
     var table = $("#mdl-upload table tbody");
     table.append(tr);
     var tr = $("#mdl-upload table tbody tr:last");
     tr.attr("id",file.id);
     tr.children("td:first-child").html(file.name);
     tr.children("td:nth-child(2)").html('<div class="progress progress-striped progress-success active"> <div style="width: 1%;" class="bar"></div> </div>');
     tr.children("td:nth-child(3)").html(util.fileSizeStr(file.size));
     tr.children("td:nth-child(4)").html("<div class='btn-group' data-toggle='buttons-radio'><button class='btn' title='暂停'><i class='icon-pause'></i></button><button class='btn' title='移除'><i class='icon-remove'></i></button></div>");
     // start the upload since it's queued
     $(this).swfupload('startUpload');
  })
  .bind('fileQueueError', function(event, file, errorCode, message){
   //$('#log').append('<li>File queue error - '+message+'</li>');
  })
  .bind('fileDialogStart', function(event){
  // $('#log').append('<li>File dialog start</li>');
  })
  .bind('fileDialogComplete', function(event, numFilesSelected, numFilesQueued){
  // $('#log').append('<li>File dialog complete</li>');
  })
  .bind('uploadStart', function(event, file){
  // $('#log').append('<li>Upload start - '+file.name+'</li>');
  })
  .bind('uploadProgress', function(event, file, bytesLoaded){
   //$('#log').append('<li>Upload progress - '+bytesLoaded+'</li>');
  })
  .bind('uploadSuccess', function(event, file, serverData){
   //$('#log').append('<li>Upload success - '+file.name+'</li>');
  })
  .bind('uploadComplete', function(event, file){
  // $('#log').append('<li>Upload complete - '+file.name+'</li>');
   // upload has completed, lets try the next one in the queue
   $(this).swfupload('startUpload');
  })
  .bind('uploadError', function(event, file, errorCode, message){
  // $('#log').append('<li>Upload error - '+message+'</li>');
  });
}); 
