//canvas 模板

//設置ID與文字樣式
const canvas = document.getElementById("canvas");
const ctxt = canvas.getContext("2d");

ctxt.fillStyle = "#009578";
ctxt.font = "bold 24px sans-serif";
ctxt.fillText("這框架文字來自於canvas.js檔,需討論下文字檔是否在html改,還是另創一個專門改文字的檔案",150,150);


