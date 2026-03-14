const fs = require('fs');
const path = require('path');

const fullPath = path.join(__dirname, 'example.txt');
const targetPath = path.join(__dirname, './text-1.txt');

// 내용 읽기
const content = fs.readFileSync(fullPath, 'utf-8');

// ./text-1.txt에 내용 적기
fs.writeFileSync(targetPath, content);
