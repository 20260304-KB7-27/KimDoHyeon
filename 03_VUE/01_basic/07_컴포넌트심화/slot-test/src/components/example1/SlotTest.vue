<template>
  <div>
    <h2>당신이 경험한 프론트엔드기술은?(Slot 사용O)</h2>

    <CheckBox2
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :checked="item.checked"
      :label="item.label"
      @check-change="checkBoxChanged"
    >
      <p>내용 추가</p>
    </CheckBox2>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import CheckBox2 from './CheckBox2.vue';

const items = ref([
  { id: 'V', checked: true, label: 'Vue' },
  { id: 'A', checked: false, label: 'Angular' },
  { id: 'R', checked: false, label: 'React' },
  { id: 'S', checked: false, label: 'Svelte' },
]);

function checkBoxChanged(e) {
  let item = items.value.find((item) => item.id === e.id);
  item.checked = e.checked;
}
</script>

<style lang="scss" scoped></style>
