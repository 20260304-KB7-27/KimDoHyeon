const fs = require('fs');
const path = require('path');

const filePath = path.join(__dirname, 'example.txt');
const savePath = path.join(__dirname, './text-1.txt');

// 파일 경로/example.txt 읽어오기
const data = fs.readFileSync(filePath, 'utf-8');

// ./text-1.txt 파일 있으면
// if (fs.existsSync(savePath)) {
//   console.log('파일이 존재합니다.');
// } else {
//   // 없을 땐 생성
//   fs.writeFileSync(savePath, data);
// }

fs.readFile(filePath, 'utf-8', (err, data) => {
  // filePath 읽기
  // 실패 시
  if (err) {
    console.log(err);
    return;
  }
  // 성공 시
  fs.writeFile(savePath, data, (err) => {
    // savePath에 쓰기.
    // 실패 시
    if (err) {
      console.log(err);
      return;
    }
    // 성공 시
    console.log('파일 생성 완료');
  });
});
