const fs = require('fs');

// 스트림으로 읽음.(스트림은 버퍼 형태로 데이터가 옴!!)
// 문자열로 보려면 인코딩 지정해야 함. utf-8 이거.
const rs = fs.createReadStream(__dirname + '/readMe.txt');

rs.on('data', (chunk) => {
  // 스트림 문자 = data
  //   console.log('데이터 준비 됨' + chunk); 이렇게 하면 문자열 더하기로 인식 되어서 자동 toString() 변환됨.
  console.log('데이터 준비 됨');
  console.log(chunk);
})
  .on('end', () => {
    // end는 '스트림 다 읽었다면' 임.
    console.log('읽기 작업 끝');
  })
  .on('error', (err) => {
    console.log('에러남: ' + err);
  });
