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
      ['Akiba haiozi', 'Damu nzito kuliko maji', 'Follow bees and you will get honey', 'Gratitude of a donkey is a kick.', 'Hurry hurry has no blessings','Every door with its own key'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
  
  document.getElementById("btnHello").style.paddingTop='100px';
}

async function getLikes(){
  const responseFromServer = await fetch('/hello');
  const textFromResponse = await responseFromServer.text();

  const commentContainer = document.getElementById('comment');
  commentContainer.innerText = textFromResponse;

  var confettiSettings = { target: 'my-canvas' };
  var confetti = new ConfettiGenerator(confettiSettings);
  confetti.render();
}


function loadContactList(){
    fetch('/list-contacts').then(response => response.json()).then((contacts) => {
    const contactListElement = document.getElementById('listOfContacts');
    contacts.forEach((contact) => {
      contactListElement.appendChild(createListElement(contact));
    })
  });


  window.location.assign(contactList.html);
}

function createListElement(content){
    const item = document.createElement('li');
    item.className = 'contact';

    const titleElement = document.createElement('span');
    titleElement.innerText = content.name + "\n" + content.message;

    item.appendChild(titleElement);
    return item;
}

