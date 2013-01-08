$(function(){
   $('#swfupload-ctrl').swfupload({
  upload_url: "http://localhost:8080/app/file/upload?realSessionId="+window["sessionId"],
  post_params: { "JSESSIONID" : window["sessionId"] ,"currentFolderId" : $("#current_folder_id").val()},
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
	  $("#mdl-upload table tbody").append("<tr>"+$("#mdl-upload table tbody tr:first").html()+"</tr>");
     var tr = $("#mdl-upload table tbody tr:last");
     tr.attr("id",file.id);
     tr.children("td:first-child").html(file.name);
     tr.children("td:nth-child(3)").html(util.fileSizeStr(file.size));
     // start the upload since it's queued
     $(this).swfupload('startUpload');
  })
  .bind('fileQueueError', function(event, file, errorCode, message){
	  log.error("fileQueueError event! message",message);
  })
  .bind('fileDialogStart', function(event){
	  log.debug("fileDialogStart event! ");
  })
  .bind('fileDialogComplete', function(event, numFilesSelected, numFilesQueued){
	  log.debug("fileDialogComplete event! numFilesSelected: ",numFilesSelected, ", numFilesQueued: "+numFilesQueued);
  })
  .bind('uploadStart', function(event, file){
	  log.debug("upload Start:"+file.name);
	  var $tr = $("#mdl-upload table tbody tr#"+file.id);
	  $tr.find("td:eq(3) span:first").html("Uploading");
  })
  .bind('uploadProgress', function(event, file, bytesLoaded){
   //$('#log').append('<li>Upload progress - '+bytesLoaded+'</li>');
	  var $tr = $("#mdl-upload table tbody tr#"+file.id);
	  $tr.find("td:eq(1) div > div").css("width",Math.round(bytesLoaded * 100/file.size) +"%");
  })
  .bind('uploadSuccess', function(event, file, serverData){
	  log.debug(file.name+" upload success!");
	  var $tr = $("#mdl-upload table tbody tr#"+file.id);
	  $tr.find("td:eq(1) div div ").addClass("bar-success");
	  $tr.find("td:eq(3) span:first").text("Success").addClass("label-success");
  })
  .bind('uploadComplete', function(event, file){
  // $('#log').append('<li>Upload complete - '+file.name+'</li>');
   // upload has completed, lets try the next one in the queue
	  log.debug("uploadComplete event! fileName:",file.name);
   $(this).swfupload('startUpload');
  })
  .bind('uploadError', function(event, file, errorCode, message){
	  log.error("uploadError event! fileName:",file.name,", error msg:",message);
	  var $tr = $("#mdl-upload table tbody tr#"+file.id);
	  $tr.find("td:eq(1) div div ").addClass("bar-danger");
	  $tr.find("td:eq(3) span:first").text("Fail").addClass("label-important");
  });
 
}); 
