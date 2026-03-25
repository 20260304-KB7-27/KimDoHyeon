<template>
  <h2>2. 범위 CSS(Scoped)</h2>
  <div class="box">Scoped CSS가 적용된 박스입니다.</div>
</template>

<script setup></script>

<style scoped>
/* 
Scoped 속성
- 이 컴포넌트에만 스타일을 적용
- Vue가 data-v-해시값 속성을 생성하여 적용함.(Vue가 알아서 해줌!)
- 다른 컴포넌트의 같은 클래스명과 충돌하지 않음.
*/
.box {
  background-color: aqua;
  border: 2px solid blue;
}
</style>
