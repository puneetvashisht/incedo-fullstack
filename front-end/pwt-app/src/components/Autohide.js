import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Toast from 'react-bootstrap/Toast';

function Autohide(props) {
  const [show, setShow] = useState(true);

  return (
    <Row>
      <Col xs={6}>
        <Toast onClose={() => setShow(false)} show={show} delay={3000} autohide>
          <Toast.Header>
            <img
              src="holder.js/20x20?text=%20"
              className="rounded me-2"
              alt=""
            />
            <strong className="me-auto">Alert</strong>
            <small>Imp info</small>
          </Toast.Header>
          <Toast.Body>{props.message}</Toast.Body>
        </Toast>
      </Col>
    </Row>
  );
}

export default Autohide;