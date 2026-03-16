const fs = require('fs');

// 스트림으로 읽음.(스트림은 버퍼 형태로 데이터가 옴!!)
// 문자열로 보려면 인코딩 지정해야 함. utf-8 이거.
const rs = fs.createReadStream(__dirname + '/readMe.txt');
const ws = fs.createWriteStream(__dirname + '/writeMe.txt');

// 파이프(pipe)
// - 스트림을 연결하는 스트림
// - data 이벤트가 발생했을 때 데이터를 읽어오고 쓰는 것을 한 번에 처리 가능.

// Buffer 그대로 파일에 쓰지만
// 파일 형식이 txt라서 텍스트 편집기가 알아서 utf-8로 해석해서 보여줌.
rs.pipe(ws);
