import { defineStore } from 'pinia';
import { ref, computed } from 'vue';

// "defineStore('like' "에서 like는 고유 id임.
export const useLikeStore = defineStore('like', () => {
  // state
  const like = ref(Number(sessionStorage.getItem('like-session')) || 0);

  // getter
  // 여러 컴포넌트에서 사용하는(공유되는) 계산 값
  const fivetime = computed(() => like.value * 5);

  // actions
  function increment() {
    like.value++;

    /*
    SessionStorage
    - 현재 '탭'에서만 유지된 ( 임시 데이터, 일회성 상태 )
    */
    sessionStorage.setItem('like-session', like.value);
  }

  return { like, fivetime, increment };
});
