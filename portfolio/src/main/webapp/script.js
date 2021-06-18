// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
<<<<<<< HEAD
      ['Akiba haiozi', 'Damu nzito kuliko maji', 'Follow bees and you will get honey', 'Gratitude of a donkey is a kick.', 'Hurry hurry has no blessings','Every door with its own key'];
=======
      ['You change your life by changing your heart.', "You don't have to be great to get started, but you have to get started to be great.", 'Inauma lakini inabidi uzoe','It is what it is','Pain is temporary, memories are forever' ];
>>>>>>> 70d24ea29d0ec84a29e11ae99170bc20d5ae670d

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
  
  document.getElementById("btnHello").style.paddingTop='100px';
}
