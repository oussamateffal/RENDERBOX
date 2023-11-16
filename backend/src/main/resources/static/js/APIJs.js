// Delete photos from project

   $(document).ready(function() {
       $(".deletePhotoFromProject").click(function(e) {
           e.preventDefault();
           var $clickedLink = $(this);
           var projectId = $(this).data("project-id");
           var photoId = $(this).data("photo-id");
           var csrfTokenValue = $("input[name='_csrf']").val();
           $.ajax({
               type: "Delete",
               url: "/api/projects/" + projectId + "/photos/" + photoId,
               beforeSend: function(xhr) {
                   xhr.setRequestHeader('X-CSRF-TOKEN', csrfTokenValue);
               },
               success: function() {
                   $("#projectPhotoContainer"+photoId).hide();
                   $("#photoDeletedToast").toast('show');
               },
               error: function() {
                   console.log("Error while delete photo!");
               }
           });
       });
   });