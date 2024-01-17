import React, { useState } from 'react';
import axios from 'axios';

function ContactForm() {
  const initialFormData = { id: '', name: '', email: '', message: '' };
  const [formData, setFormData] = useState(initialFormData);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios.post('http://localhost:8085/contacts', formData)
      .then((response) => {
        alert("Message sent\nStatus: " + response.statusText);
        setFormData(initialFormData); // Reset the form fields to initial values
      })
      .catch((error) => {
        alert("Message not sent\nStatus: " + error.response.statusText);
      });
  };

  return (
    <div className="card text-center mt-4 crv-8 p-3 bx-shadow" style={{ backgroundColor: '#b5777e' }}>
      <h4 className="text-left font-weight-bold">
        Let's talk
      </h4>
      <form onSubmit={handleSubmit} method="post" className="mt-2">
        <div className="input-group">
          <div className="input-group-prepend">
            <span className="input-group-text ion-person" style={{ marginRight: '15px' }}></span>
          </div>
          <input type="text" className="form-control" id="name" name="name" onChange={handleChange} value={formData.name} placeholder="Name (Optional)" />
        </div>
        <div className="input-group mt-2">
          <div className="input-group-prepend">
            <span className="input-group-text ion-email" style={{ marginRight: '5px' }}></span>
          </div>
          <input type="text" className="form-control" id="email" name="email" onChange={handleChange} value={formData.email} required placeholder="Email" />
        </div>
        <textarea name="message" id="message" rows="5" className="form-control mt-2" onChange={handleChange} value={formData.message} placeholder="Message"></textarea>
        <button type="submit" className="btn custom-btn-color btn-block mt-3 crv-25" style={{ backgroundColor: '#77b5ae' }}>Send now</button>
      </form>
    </div>
  );
}

export default ContactForm;
