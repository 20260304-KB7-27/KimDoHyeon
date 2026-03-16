// const fs = require('fs').promises;
const fs = require('fs/promises'); // 이게 최신 방식.

// Promise then/catch 방식
// fs.readdir('./')
//   .then((files) => {
//     console.log(files);
//   })
//   .catch((err) => {
//     console.error(err);
//   });

// async/await 방식
async function readDir() {
  // catch 대신 try/catch
  try {
    const filse = await fs.readdir('./'); // then 대신 await
    console.log(filse);
  } catch (err) {
    console.error(err);
  }
}

readDir();
