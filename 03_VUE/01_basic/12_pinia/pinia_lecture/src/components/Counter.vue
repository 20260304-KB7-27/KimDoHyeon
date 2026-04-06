<template>
  <h3>반응형으로 꺼내기: {{ counter.count }}</h3>
  <br />
  <h3>값만 꺼내기: {{ count }}</h3>
  <br />
  <button @click="increment">+ 증가</button>
  <button @click="reset">초기화</button>
</template>

<script setup>
// import { useCounterStore } from '@/stores/counter';
import { useCounterPersistStore } from '@/stores/persist/persist_counter';

// State를 꺼낼 때는 구조분해 할당을 하게 되면, 반응형이 깨짐
// const counter = useCounterStore(); // 객체 자체를 꺼내서 쓰는 방식
const counter = useCounterPersistStore(); // 객체 자체를 꺼내서 쓰는 방식

// const { count, increment, reset } = useCounterStore(); // 구조분해할당으로 꺼내는 방식
const { count, increment, reset } = useCounterPersistStore(); // 구조분해할당으로 꺼내는 방식

// 구조분해할당은 값만 복사하기 때문에 반응형이 사라짐.
// 객체 자체를 꺼내는 방식은 참조값을 가져오기 때문에 반응형이 유지됨.
</script>

<style lang="scss" scoped></style>
