import { defineStore } from 'pinia';
import { ref, computed } from 'vue';

export const useLikePersistStore = defineStore(
  'like-persist',
  () => {
    // state
    const like = ref(0);

    // getter
    const fivetime = computed(() => like.value * 5);

    // actions
    function increment() {
      like.value++;
    }

    return { like, fivetime, increment };
  },
  {
    persist: {
      key: 'like_p', // storage에 저장될 key 이름 (기본값 store ID)
      storage: sessionStorage, // 기본값: localStorage
      pick: ['like'], // 저장하고 싶은 상태값 지정 가능
    },
  },
);
