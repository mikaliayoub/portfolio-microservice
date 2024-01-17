import React from 'react';



// Sidebar
function Sidebar() {
  return (
    <div className="glass-card sidebar">
      <h4 className="name p-3">
        GHAZALI Loubna<br />
        <small className="font-weight-normal">
          Software Developer
        </small>
      </h4>


      <div className="key-points">
        <ul className="text-white pl-5 pr-2 list-unstyled">
          <li className="big"></li>
          <li>
            <span className="font-weight-bold">Contact: </span><br />
            <i className="ion-email text-white"></i>
            <span className="ml-2">loubna.ghazali16@gmail.com</span><br />
          </li>
          <li>
            <span className="font-weight-bold">Web Development: </span><br />
            <span>HTML/CSS/JavaScript, ReactJs, Django, Angular</span>
          </li>
          <li>
            <span className="font-weight-bold">Mobile Application: </span><br />
            <span>Java, Flutter, React Native</span>
          </li>
          <li>
            <span className="font-weight-bold">Databases: </span><br />
            <span>Firebase, MySQL, MongoDB, Postgres SQL, SQLite</span>
          </li>
        </ul>
      </div>
    </div>
  );
}

export default Sidebar;
