const fs = require('fs');
const path = require('path');

const targetPath = path.dirname(__filename) + '/test';

if (fs.existsSync(targetPath)) {
  console.log('폴더 존재함.');
} else {
  fs.mkdir(targetPath, (err) => {
    if (err) {
      return console.log('폴더 생성 실패: ' + err);
    }
    console.log('폴더 생성 완료');
  });
}
