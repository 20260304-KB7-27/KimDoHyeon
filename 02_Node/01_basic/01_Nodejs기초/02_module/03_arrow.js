// 화살표함수

let getTriangle = (base, height) => {
  (base * height) / 2;
  // 추가 코드 작성
};

console.log('삼각형의 면적: ' + getTriangle(5, 2));

//
const person = {
  name: 'dodo',

  // 일반 함수, this로 person 뱉음.
  hello1: function () {
    console.log('일반함수: ', this);
  },

  // 화살표 함수, this를 찾지 못함.
  hello2: () => {
    console.log('화살표함수: ' + this);
  },
};

person.hello1();
person.hello2();
