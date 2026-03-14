const fs = require('fs');
const path = require('path');

// example.txt의 풀경로
const fullPath = path.join(__dirname, 'example.txt');

// 내용 읽기
const content = fs.readFileSync(fullPath, 'utf-8');

console.log(content);
