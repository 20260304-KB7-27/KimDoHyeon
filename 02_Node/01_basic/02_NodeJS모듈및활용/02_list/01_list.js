const fs = require('fs'); // fs 모듈 가져오기

// readdir: 폴더 안의 파일 목록을 읽는 함수

// 동기 방식
let files = fs.readdirSync('./');
// console.log(files);

// 콜백 방식
// (err, files) => { } 는 화살표 익명함수임.
// 원래는 function 함수명(err, files) { } 인 것.
// function(err, files) { } 는 일반 익명함수.
fs.readdir('./', (err, files) => {
  if (err) {
    console.err(err);
    return;
  }
  console.log(files);
});

// Promise 방식
fs.promises
  .readdir('./')
  .then((files) => {
    console.log(files);
  })
  .catch((err) => {
    console.log(err);
  });
