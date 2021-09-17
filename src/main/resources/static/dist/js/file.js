async function makeFile(){
   let selectedFileName = document.getElementById("files").value;

   let response = await getReportRequest(selectedFileName);
   let dataX;

    try {
        dataX = response.content;

    } catch (error) {
        window.alert("Arquivo não existe");
        return;
    }
    if(dataX == null || dataX == undefined){
        window.alert("Arquivo não existe");
        return;

    }
     console.log(response.status);
     var hiddenElement = document.createElement('a');  
     hiddenElement.href = 'data:text/plain;charset=utf-8,' + encodeURI(dataX);
     hiddenElement.target = '_blank';
     hiddenElement.download = response.fileName;
     hiddenElement.click();
}

async function getReportRequest(fileName){
    let currentUrl = window.location.origin;
    let response = await fetch(currentUrl+"/file/?fileName="+fileName,{
            method: "GET",
            headers: {
                "Authorization": 'Basic ' +  'MXVuaXF1ZUF1dGgxOjFhdXRoMTIzNDU2',
                'Content-Type': 'application/json'
            }
    }).then(response => response.json());

    return response;
}


async function getRequest(){
    let currentUrl = window.location.origin;

    let response = await fetch(currentUrl+"/file/list",{
            method: "GET",
            headers: {
                "Authorization": 'Basic ' +  'MXVuaXF1ZUF1dGgxOjFhdXRoMTIzNDU2',
                'Content-Type': 'application/json'
            }
    }).then(response => response.json());

    return response;
}

 async function getFileList() {
    let dropdown = document.getElementById('files');
    const data = await getRequest();
    let option;
    for (let i = 0; i < data.length; i++) {
      option = document.createElement('option');
      option.text = data[i];
      option.value = data[i];
      dropdown.add(option);
    }
 }





