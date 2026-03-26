<script setup>
import { ref } from 'vue';
// import InputName from './components/InputName.vue';
import BaseInput from './components/BaseInput.vue';

// const searchName = ref('')
const modelValue = ref('');
const lastname = ref('');
const firstname = ref('');
</script>

<template>
  <div>
    <BaseInput
      v-model:modelValue="lastname"
      label="성"
      placeholder="성을 입력해주세요."
    ></BaseInput>
    <BaseInput
      v-model:modelValue="firstname"
      label="이름"
      placeholder="이름을 입력해주세요"
    />
    <BaseInput
      v-model:modelValue="modelValue"
      label="닉네임"
      placeholder="닉네임을 입력해주세요"
    />
    <h3>
      닉네임 : <strong>{{ modelValue }}</strong>
    </h3>
    <h3>
      전체 이름 : <strong>{{ firstname }} {{ lastname }}</strong>
    </h3>
  </div>
</template>

<style scoped></style>
