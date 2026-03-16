const fs = require('fs');
const path = require('path');

// example.txt의 풀경로
const fullPath = path.join(__dirname, 'example.txt');

// 내용 읽기
fs.readFile(fullPath, 'utf-8', (err, files) => {
  if (err) {
    console.log(err);
    return;
  }
  console.log(files);
});
