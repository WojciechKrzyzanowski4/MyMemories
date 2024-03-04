function functionToDoShitNow(event){
    var selectedFile = event.target.files[0];
    var selectedImage = document.getElementById('selectedImage');

    alert("wchodze");
    if(!selectedFile.type.match('image.*')){
        alert("Please select an image file.")
        return;
    }

    var reader = new FileReader();
    reader.onload = function(event) {
        selectedImage.src = event.target.result;
        document.getElementById('selectedImageDiv').style.display = 'block';
    };
    reader.readAsDataURL(selectedFile);
}